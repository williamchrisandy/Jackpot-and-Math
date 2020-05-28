package com.example.m_oopfinalproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.text.Html;
import android.view.View;
import android.widget.TextView;

import java.util.Timer;
import java.util.TimerTask;

public class JackpotGBKActivity extends AppCompatActivity {
    // This is a Java port of "Jackpot GBK" (https://github.com/reinhart1010/jackpotgbk/) web game,
    // while utilizing Object-Oriented Programming concept and rewritten from scratch. Unlike the
    // original game, multiple users cannot play the slot at the same time, as the slot selection
    // process are handled on a separate Activity.

    // For more information on how this game works, see https://reinhart1010.github.io/jackpotgbk/

    public void onBackPressed(){
        finish();
    }

    // Set 2 players
    public JackpotGBKPlayer[] players = new JackpotGBKPlayer[2];

    // Lock the Player 1 and 2 slot progress (will be further explained on this source code)
    private int player1RemainingSlots = 3, player2RemainingSlots = 3;
    private char[] player1Slot = {'n', 'n', 'n'}, player2Slot = {'n', 'n', 'n'};
    private char player1CurrentRandomState, player2CurrentRandomState;
    private char[] randomChars = {'g', 'b', 'k'};

    // Handler utilities
    private Handler player1Handler = new Handler();
    private Handler player2Handler = new Handler();

    // A Runnable for randomizing items in Player 1
    private Runnable player1Updater = new Runnable(){
        @Override
        public void run(){
            if (player1RemainingSlots >= 0) {
                player1Slot[2 - player1RemainingSlots] = randomChars[(int) (Math.random() * 3)];
                updateSlotViews(1);
                player1Handler.postDelayed(this, 200);
            } else {
                player1RemainingSlots = 3;
                checkOutSlot(player1Slot, players[0]);
                checkOutMoves();
                player1Slot[0] = player1Slot[1] = player1Slot[2] = 'n';
                updateViews();
            }
        }
    };

    // A Runnable for randomizing items in Player 2
    private Runnable player2Updater = new Runnable(){
        @Override
        public void run(){
            if (player2RemainingSlots >= 0) {
                player2Slot[2 - player2RemainingSlots] = randomChars[(int) (Math.random() * 3)];
                updateSlotViews(2);
                player2Handler.postDelayed(this, 200);
            } else {
                player2RemainingSlots = 3;
                checkOutSlot(player2Slot, players[1]);
                checkOutMoves();
                player2Slot[0] = player2Slot[1] = player2Slot[2] = 'n';
                updateViews();
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jackpotgbk);
        players[0] = new JackpotGBKPlayer("Player 1");
        players[1] = new JackpotGBKPlayer("Player 2");
    }

    // Convert movement states to emojis
    // For maximum compatibility with various Android versions and device manufacturers, we have
    // selected ones which are part of Unicode 6.0 and Emoji 1.0 standards by Unicode (2010; 2015).
    // Note that we currently do not include the EmojiCompat library as recommended by Google.
    private String resolveStateSymbol(char state, boolean useHands){
        if (useHands) switch (state){
            case 'n': return "&#x274C;"; // Unicode 6.0 (2010), Emoji 1.0 (2015)
            case 'g': return "&#x270C;&#xFE0F;"; // Unicode 1.1 (1993), Emoji 1.0 (2015)
            case 'b': return "&#x1F44A;"; // Unicode 6.0 (2010), Emoji 1.0 (2015)
            case 'k': return "&#x270B;"; // Unicode 6.0 (2010), Emoji 1.0 (2015)
        } else switch (state) {
            case 'n': return "&#x274C;"; // Unicode 6.0 (2010), Emoji 1.0 (2015)
            case 'g': return "&#x2702;&#xFE0F;"; // Unicode 1.1 (1993), Emoji 1.0 (2015)
            case 'b': return "&#x1F5FF;"; // Unicode 6.0 (2010), Emoji 1.0 (2015)
            case 'k': return "&#x1F4C3;"; // Unicode 6.0 (2010), Emoji 1.0 (2015)
        }
        return "&#x274C;";
    }

    // Update Android Views (to defaults)
    private void updateViews(){
        TextView temp;
        StringBuilder res;
        // Update Player 1 Name
        temp = findViewById(R.id.player1_name);
        temp.setText(players[0].name);
        // Update Player 2 Name
        temp = findViewById(R.id.player2_name);
        temp.setText(players[1].name);
        // Update Player 1 Score
        temp = findViewById(R.id.player1_score);
        temp.setText(String.valueOf(players[0].score));
        // Update Player 2 Score
        temp = findViewById(R.id.player2_score);
        temp.setText(String.valueOf(players[1].score));
        // Update Player 1 Pending Moves
        temp = findViewById(R.id.player1_list);
        res = new StringBuilder();
        for (char move : players[0].getPendingMoves()) res.append(resolveStateSymbol(move, false));
        temp.setText(Html.fromHtml(res.toString()));
        // Update Player 2 Pending Moves
        temp = findViewById(R.id.player2_list);
        res = new StringBuilder();
        for (char move : players[1].getPendingMoves()) res.append(resolveStateSymbol(move, false));
        temp.setText(Html.fromHtml(res.toString()));
    }

    // Update player's slot views
    private void updateSlotViews(int player){
        TextView temp;
        StringBuilder res = new StringBuilder();;
        int i;

        if (player == 1){
            temp = findViewById(R.id.player1_score);
            if (player1RemainingSlots < 0){
                temp.setText(String.valueOf(players[0].score));
                return;
            }
            i = 0;
            while (i < 3 && player1Slot[i] != 'n'){
                res.append(resolveStateSymbol(player1Slot[i], false));
                i++;
            }
            temp.setText(Html.fromHtml(res.toString()));
        } else if (player == 2){
            temp = findViewById(R.id.player2_score);
            if (player2RemainingSlots < 0){
                temp.setText(String.valueOf(players[1].score));
                return;
            }
            i = 0;
            while (i < 3 && player2Slot[i] != 'n'){
                res.append(resolveStateSymbol(player2Slot[i], false));
                i++;
            }
            temp.setText(Html.fromHtml(res.toString()));
        }
    }

    // In-game mechanisms
    // Basic GBK (Rock, Paper, Scissors; aka. Roshambo) logic applies with additional constraints

    // Validates movement states:
    boolean isValid(char state){
        switch (state) {
            case 'n': // NULL
            case 'g': // Scissors
            case 'b': // Rock
            case 'k': return true; // Paper
            default: return false; // 'u' will be considered invalid as well.
        }
    }

    // Mechanism to start the slot
    public void toggleSlot(View current){
        int currentId = current.getId();
        if (currentId != R.id.player1_button && currentId != R.id.player2_button) return;
        int player = (currentId == R.id.player1_button) ? 1 : 2;

        // Checks the slot progress on each players
        randomizeSlot(player);
    }

    // Mechanism to randomize the slot
    private void randomizeSlot(final int player){
        if (player < 1 || player > 2) return;
        final TextView current = findViewById((player == 1) ? R.id.player1_score : R.id.player2_score);
        int remainingSlots = (player == 1) ? player1RemainingSlots : player2RemainingSlots;

        if (player == 1){
            player1RemainingSlots--;
            if (player1RemainingSlots == 2) player1Handler.post(player1Updater);
            //if (player1RemainingSlots < 2 && player1RemainingSlots >= -1) player1Slot[1 - player1RemainingSlots] = player1CurrentRandomState;
        } else {
            player2RemainingSlots--;
            if (player2RemainingSlots == 2) player2Handler.post(player2Updater);
            //if (player2RemainingSlots < 2 && player2RemainingSlots >= -1) player2Slot[1 - player2RemainingSlots] = player2CurrentRandomState;
        };
        //updateViews();
    }

    // Check out the slot
    void checkOutSlot(char[] slot, JackpotGBKPlayer current){
        if (slot.length != 3) return;
        int g = 0, b = 0, k = 0, i;
        for (i = 0; i < 3; i++) switch(slot[i]){
            case 'g': g++; break;
            case 'b': b++; break;
            case 'k': k++; break;
        };

        // Adapted from original Jackpot GBK codebase
        if (g >= 2){
            current.pushMove('g');
            if (g == 3) current.pushMove('g');
        } else if (b >= 2){
            current.pushMove('b');
            if (b == 3) current.pushMove('b');
        } else if (k >= 2){
            current.pushMove('k');
            if (k == 3) current.pushMove('k');
        } else current.pushMove('n');
    }

    // Check out the pending moves
    private void checkOutMoves(){
        if (players[0].getPendingMoves().size() * players[1].getPendingMoves().size() == 0) return;
        char player1Move, player2Move;
        int res;
        while (players[0].getPendingMoves().size() > 0 && players[1].getPendingMoves().size() > 0){
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
            }
            player1Move = players[0].popMove();
            player2Move = players[1].popMove();
            res = whichWins(player1Move, player2Move);
            switch (res){
                case 1: players[0].score++; break;
                case 2: players[1].score++; break;
                default: return;
            };
        }
    }

    // Determine which players wins. Normal GBK rules apply, while the non-NULL player wins over a
    // NULL player.
    // Output codes:
    // -1: Error
    // 0 : No winners
    // 1 : Player 1 wins
    // 2 : Player 2 wins
    int whichWins(char player1, char player2){
        if (!isValid(player1) || !isValid(player2)) return -1;
        // If both players have the same state, then no winners are awarded.
        if (player1 == player2) return 0;
        // The non-NULL player wins over a NULL player.
        // *NULL refers to the player's movement state.
        else if (player2 == 'n') return 1;
        else if (player1 == 'n') return 2;
        // The below code assumes that the players' moves are unique and limited to G, B, and K.
        // + G (Scissors) wins over K (Paper)
        // + B (Rock) wins over G (Scissors)
        // + K (Paper) wins over B (Rock)
        switch (player1){
            case 'g': return (player2 == 'k') ? 1 : 2;
            case 'b': return (player2 == 'g') ? 1 : 2;
            case 'k': return (player2 == 'b') ? 1 : 2;
        };
        // If the Method does not return anything before this point, that's an error.
        return -1;
    }
}
