
/*
 * Copyright Adrian Raff 2018.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:
 * The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 *
 */

package com.example.android.courtcounter;

import android.content.res.Resources;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    /**
     * Random generator
     */

    private static final Random rgenerator = new Random();
    /**
     * Set up a variable to keep score for team A
     */

    int scoreTeamA = 0;
    /**
     * Set up a variable to keep score for team B
     */

    int scoreTeamB = 0;
    /**
     * Set up name variables for the players
     */

    String playerTwo = Main2Activity.etPlayer2.getText().toString();
    String playerOne = Main2Activity.etPlayer1.getText().toString();
    /**
     * This string will be used to store winner message.
     */
    String winnerString = "";
    /**
     * Sound effects
     */
    MediaPlayer mpToiletFlush;
    MediaPlayer mpCensorBeep;
    MediaPlayer mpSadLoser;
    MediaPlayer mpBgMusic;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        /**
         * BG Music start
         *
         */
        bgMusic();

        // Call our first methods to display player names
        displayPlayerTwoName(playerTwo);
        displayPlayerOneName(playerOne);

    }

    /**
     * Displays the given score for team A.
     */

    public void displayForTeamA(int score) {
        TextView scoreView = findViewById(R.id.team_a_score);
        scoreView.setText(String.valueOf(score));
    }

    /**
     * Display name of player two
     */
    public void displayPlayerOneName(String name) {
        TextView scoreView = findViewById(R.id.team_a_tag);
        scoreView.setText(String.valueOf(name));
    }

    /**
     * Increase score by 3 for team A
     */
    public void threePointsForTeamA(View v) {
        scoreTeamA = scoreTeamA + 3;
        displayForTeamA(scoreTeamA);
        playCensorBeep();
        checkScore();
    }

    /**
     * Increase score by 2 for team A
     */
    public void twoPointsForTeamA(View v) {
        scoreTeamA = scoreTeamA + 2;
        displayForTeamA(scoreTeamA);
        playCensorBeep();
        checkScore();
    }

    /**
     * Increase score by 1 for team A
     */
    public void onePointForTeamA(View v) {
        scoreTeamA = scoreTeamA + 1;
        displayForTeamA(scoreTeamA);
        playCensorBeep();
        checkScore();
    }


    /**
     * Displays the given score for Team B
     */
    public void displayForTeamB(int score) {
        TextView scoreView = findViewById(R.id.team_b_score);
        scoreView.setText(String.valueOf(score));
    }

    /**
     * Display name of player two
     */
    public void displayPlayerTwoName(String name) {
        TextView scoreView = findViewById(R.id.team_b_tag);
        scoreView.setText(String.valueOf(name));
    }

    /**
     * Increase score by 3 for team B
     */
    public void threePointsForTeamB(View v) {
        scoreTeamB = scoreTeamB + 3;
        displayForTeamB(scoreTeamB);
        playCensorBeep();
        checkScore();
    }

    /**
     * Increase score by 2 for team B
     */
    public void twoPointsForTeamB(View v) {
        scoreTeamB = scoreTeamB + 2;
        displayForTeamB(scoreTeamB);
        playCensorBeep();
        checkScore();
    }

    /**
     * Increase score by 1 for team B
     */
    public void onePointForForTeamB(View v) {
        scoreTeamB = scoreTeamB + 1;
        displayForTeamB(scoreTeamB);
        playCensorBeep();
        checkScore();
    }

    /**
     * Reset the game
     */
    public void resetScore(View v) {
        scoreTeamA = 0;
        scoreTeamB = 0;
        displayForTeamA(scoreTeamA);
        displayForTeamB(scoreTeamB);
        winnerString = "Ready to play again!";
        toiletFlush();
        bgMusic();
        TextView winner = findViewById(R.id.text_who_is_winner);
        winner.setText(String.valueOf(winnerString));
    }

    /**
     * Players eat a Tide Pod washes out that potty mouth and resets score
     */
    public void resetTeamA(View v) {
        scoreTeamA = 0;

        displayForTeamA(scoreTeamA);
        displayForTeamB(scoreTeamB);
        winnerString = playerOne + " eats a TIDE POD! Ultra clean mouth!";
        toiletFlush();
        TextView winner = findViewById(R.id.text_who_is_winner);
        winner.setText(String.valueOf(winnerString));
    }

    public void resetTeamB(View v) {
        scoreTeamB = 0;

        displayForTeamA(scoreTeamA);
        displayForTeamB(scoreTeamB);
        winnerString = playerTwo + " eats a TIDE POD! Ultra clean mouth!";
        toiletFlush();
        TextView winner = findViewById(R.id.text_who_is_winner);
        winner.setText(String.valueOf(winnerString));
    }

    /**
     * These methods are to play sound effects when button is clicked. I used MediaPlayer here.
     * TDL: There is an odd bug here where continuous clicks on buttons cause sound to stop working.
     */

    // Main buttons sound effect
    public void playCensorBeep() {

        if (mpCensorBeep != null) {
            mpCensorBeep.stop();
            mpCensorBeep.release();
        }

        mpCensorBeep = MediaPlayer.create(getApplicationContext(), R.raw.censorbeep);
        mpCensorBeep.start();


    }

    // General sound effect
    public void toiletFlush() {

        if (mpToiletFlush != null) {
            mpToiletFlush.stop();
            mpToiletFlush.release();
        }

        mpToiletFlush = MediaPlayer.create(getApplicationContext(), R.raw.toiletflush);
        mpToiletFlush.start();

    }

    // Loser sound effect
    public void sadLoser() {
        if (mpSadLoser != null) {
            mpSadLoser.stop();
            mpSadLoser.release();
        }

        mpSadLoser = MediaPlayer.create(getApplicationContext(), R.raw.sadloser);
        mpSadLoser.start();


    }

    // Background music
    public void bgMusic() {
        if (mpBgMusic != null) {
            mpBgMusic.stop();
            mpBgMusic.release();
        }

        mpBgMusic = MediaPlayer.create(getApplicationContext(), R.raw.bgmusic);
        mpBgMusic.start();

    }

    /**
     * This method is used to check for a winner (or loser in this case) When someone loses, play the sad loser sound effect, stop the background music
     * and display who lost.
     */

    public void checkScore() {

        String[] myMessage;

        Resources res = getResources();

        myMessage = res.getStringArray(R.array.loserMessageArray);

        String randomString = myMessage[rgenerator.nextInt(myMessage.length)];

        // Check to see if team a lost if not go to next
        if (scoreTeamA >= 50) {
            winnerString = "You have a big potty mouth " + playerOne + " YOU LOSE! " + randomString;
            TextView winner = findViewById(R.id.text_who_is_winner);
            winner.setText(String.valueOf(winnerString));
            sadLoser();
            mpBgMusic.stop();
            return;

        }
        // check to see if teab b lost if not go to next
        if (scoreTeamB >= 50) {
            winnerString = "You have a big potty mouth " + playerTwo + " YOU LOSE! " + randomString;
            TextView winner = findViewById(R.id.text_who_is_winner);
            winner.setText(String.valueOf(winnerString));
            sadLoser();
            mpBgMusic.stop();
            return;

        } else {
            // If no one has lost yet display a message stating the game is still on
            winnerString = "So far there is no big loser.";
            TextView winner = findViewById(R.id.text_who_is_winner);
            winner.setText(String.valueOf(winnerString));
        }


    }
}


