package org.project.mockito;
import java.util.Random;
import java.util.Scanner;

public class Game {

    private Scanner input = new Scanner(System.in);
    private Random random = new Random();

    public void play() {
        printGameRules();
        String choice = input.nextLine().toUpperCase();

        ScoreBoard scoreBoard = new ScoreBoard();

        while (!choice.equals("quit"))
        {
           GameOption choicenum = getChoicenum(choice);
             if(choicenum == null) {
                while(choicenum == null){
                    System.out.println("Sorry, it looks like you didn't enter a correct input. Try again.");
                    choice = input.nextLine().toUpperCase();
                    choicenum = getChoicenum(choice);
                }
            }
            GameOption compnum = getChoiceComputer();
            completeGamePlay(scoreBoard, choicenum, compnum);
            resultsGame(scoreBoard);
            choice = input.nextLine().toUpperCase();
        }
    }

    private void resultsGame(ScoreBoard scoreBoard) {
        System.out.println("wins:" + scoreBoard.getWins() + "\nloses:" + scoreBoard.getLosses() + "\nties:" + scoreBoard.getTies());
        System.out.println("Let's play again! \n \n");
        System.out.println("Say \"Rock\", \"Paper\", or \"Scissors\" to indicate your choice. Otherwise say \"Quit\" to quit.");
    }

    private void completeGamePlay(ScoreBoard scoreBoard, GameOption choicenum, GameOption compnum) {
        if(choicenum == compnum){
            ties(scoreBoard);
        }
        else if (choicenum == GameOption.ROCK && compnum == GameOption.SCISSORS
                || choicenum == GameOption.SCISSORS && compnum == GameOption.PAPER
                || choicenum == GameOption.PAPER && compnum == GameOption.ROCK){
                wins(scoreBoard);
        }
        else {
            loses(scoreBoard);
        }
    }

    private void loses(ScoreBoard scoreBoard) {
        System.out.println("you lose.");
        scoreBoard.incrementWins();
    }

    private void wins(ScoreBoard scoreBoard) {
        System.out.println("You win!");
        scoreBoard.incrementTie();
    }

    private void ties(ScoreBoard scoreBoard) {
        System.out.println("It's a tie");
        scoreBoard.incrementTie();
    }

    private GameOption getChoicenum(String choice) {
        GameOption selectedOption = null;
       if (choice.equals("quit"))
            System.exit(0);
       try {
           selectedOption = GameOption.valueOf(choice);
       }catch (Exception e){
         return null;
       }
        return selectedOption;
    }

    private GameOption getChoiceComputer() {
        GameOption option = GameOption.values()[random.nextInt(3)];
        System.out.println("Computer chose " + option.toString().toUpperCase());
        return option;
    }

    private void printGameRules() {
        System.out.println("Let's play Rock, Paper, Scissors!");
        System.out.println("Say \"Rock\", \"Paper\", or \"Scissors\" to indicate your choice. Otherwise say \"Quit\" to quit.");
    }
}