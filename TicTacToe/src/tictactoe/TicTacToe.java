/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoe;

import java.util.Scanner;

/**
 *
 * @author ishanmadan
 */
public class TicTacToe {

    public static String[][] grid = {
        {" ", " ", " "},
        {" ", " ", " "},
        {" ", " ", " "}};
    
    public static int victory = 0; // 0 is no winner yet, 1 is X, 2 is O, 3 is tie
    public static Scanner input = new Scanner(System.in);
    
    /**
     * @param args the command line arguments
     */
    
    public static void main(String[] args) {
        // TODO code application logic here
        String gameMode;
        
        System.out.println("Hello, and welcome to Tic-Tac-Toe! Do you want to play against another player or the computer? Please reply"
                + " with \"player\" or \"computer\".");
        gameMode = input.nextLine().toLowerCase().replaceAll("[^playercomut]", "");
        while (!(gameMode.equals("player") || gameMode.equals("computer"))) {
            System.out.println("I'm sorry, that's not a valid option. Please reply with either \"player\" or \"computer\".");
            gameMode = input.nextLine().toLowerCase().replaceAll("[^playercomut]", "");
        }
        
        System.out.println("This is the grid:");
        printGrid();
        System.out.println("To play, enter your selections from the grid using letter/number combos (like A1, B2, and C3) when "
                + "prompted.");
        
        if (gameMode.equals("player")) {
            player();
        } else if (gameMode.equals("computer")) {
            String compMode;
            System.out.println("Do you want to play in random mode or in intelligent mode? Please reply with either \"random\" or \"intel\".");
            compMode = input.nextLine().toLowerCase().replaceAll("[^randomintel]", "");
            
            while (!(compMode.equals("random") || compMode.equals("intel"))) {
                System.out.println("I'm sorry, that's not a valid option. Please reply with either \"random\" or \"intel\".");
                compMode = input.nextLine().toLowerCase().replaceAll("[^randomintel]", "");
            }
            
            if (compMode.equals("random")) {
                compRandom();
            } else if (compMode.equals("intel")) {
                
            } else {
                exit();
            }
        } else {
            exit();
        }
    }
    
    public static void compRandom() {
        String reply;
        boolean valid;
        
        int rand1;
        int rand2;
        
        System.out.println("Do you want to go first?");
        
        if (input.nextLine().toLowerCase().replaceAll("[^yesno]", "").equals("yes")) {
            while (victory == 0) {
                System.out.println("Enter your selection.");
                reply = input.nextLine().toLowerCase().replaceAll("[^abc123]", "");

                valid = false;

                while (!valid) {
                    if (reply.equals("a1") && grid[0][0].equals(" ")) {
                        grid[0][0] = "X";
                        valid = true;
                        printGrid();
                    } else if (reply.equals("a2") && grid[1][0].equals(" ")) {
                        grid[1][0] = "X";
                        valid = true;
                        printGrid();
                    } else if (reply.equals("a3") && grid[2][0].equals(" ")) {
                        grid[2][0] = "X";
                        valid = true;
                        printGrid();
                    } else if (reply.equals("b1") && grid[0][1].equals(" ")) {
                        grid[0][1] = "X";
                        valid = true;
                        printGrid();
                    } else if (reply.equals("b2") && grid[1][1].equals(" ")) {
                        grid[1][1] = "X";
                        valid = true;
                        printGrid();
                    } else if (reply.equals("b3") && grid[2][1].equals(" ")) {
                        grid[2][1] = "X";
                        valid = true;
                        printGrid();
                    } else if (reply.equals("c1") && grid[0][2].equals(" ")) {
                        grid[0][2] = "X";
                        valid = true;
                        printGrid();
                    } else if (reply.equals("c2") && grid[1][2].equals(" ")) {
                        grid[1][2] = "X";
                        valid = true;
                        printGrid();
                    } else if (reply.equals("c3") && grid[2][2].equals(" ")) {
                        grid[2][2] = "X";
                        valid = true;
                        printGrid();
                    } else {
                        valid = false;
                        System.out.println("I'm sorry, that's not a valid answer. Here's the grid, please try again:");
                        printGrid();
                        System.out.println("Player X, enter your selection.");
                        reply = input.nextLine().toLowerCase().replaceAll("[^abc123]", "");
                    }
                }

                checkVictory();

                if (victory == 0) {
                    rand1 = (int)(Math.random() * 3);
                    rand2 = (int)(Math.random() * 3);
                    
                    while (grid[rand1][rand2] != " ") {
                        rand1 = (int)(Math.random() * 3);
                        rand2 = (int)(Math.random() * 3);
                    }
                    
                    grid[rand1][rand2] = "O";

                    System.out.println("The computer played:");
                    printGrid();
                }

                checkVictory();
            }

            if (victory == 1) {
                System.out.println("Congratulations! You win!");
            } else if (victory == 2) {
                System.out.println("I won!");
            } else if (victory == 3) {
                System.out.println("It's a tie!");
            } else {
                exit();
            }
        } else if (input.nextLine().toLowerCase().replaceAll("[^yesno]", "").equals("no")) {
            while (victory == 0) {
                rand1 = (int)(Math.random() * 3);
                rand2 = (int)(Math.random() * 3);
                
                while (grid[rand1][rand2] != " ") {
                    rand1 = (int)(Math.random() * 3);
                    rand2 = (int)(Math.random() * 3);
                }
                
                grid[rand1][rand2] = "X";
                
                System.out.println("The computer played:");
                printGrid();
                
                checkVictory();
                
                if (victory == 0) {
                    System.out.println("Enter your selection.");
                    reply = input.nextLine().toLowerCase().replaceAll("[^abc123]", "");

                    valid = false;

                    while (!valid) {
                        if (reply.equals("a1") && grid[0][0].equals(" ")) {
                            grid[0][0] = "O";
                            valid = true;
                            printGrid();
                        } else if (reply.equals("a2") && grid[1][0].equals(" ")) {
                            grid[1][0] = "O";
                            valid = true;
                            printGrid();
                        } else if (reply.equals("a3") && grid[2][0].equals(" ")) {
                            grid[2][0] = "O";
                            valid = true;
                            printGrid();
                        } else if (reply.equals("b1") && grid[0][1].equals(" ")) {
                            grid[0][1] = "O";
                            valid = true;
                            printGrid();
                        } else if (reply.equals("b2") && grid[1][1].equals(" ")) {
                            grid[1][1] = "O";
                            valid = true;
                            printGrid();
                        } else if (reply.equals("b3") && grid[2][1].equals(" ")) {
                            grid[2][1] = "O";
                            valid = true;
                            printGrid();
                        } else if (reply.equals("c1") && grid[0][2].equals(" ")) {
                            grid[0][2] = "O";
                            valid = true;
                            printGrid();
                        } else if (reply.equals("c2") && grid[1][2].equals(" ")) {
                            grid[1][2] = "O";
                            valid = true;
                            printGrid();
                        } else if (reply.equals("c3") && grid[2][2].equals(" ")) {
                            grid[2][2] = "O";
                            valid = true;
                            printGrid();
                        } else {
                            valid = false;
                            System.out.println("I'm sorry, that's not a valid answer. Here's the grid, please try again:");
                            printGrid();
                            System.out.println("Player O, enter your selection.");
                            reply = input.nextLine().toLowerCase().replaceAll("[^abc123]", "");
                        }
                    }
                }
                
                checkVictory();
            }
            
            if (victory == 1) {
                System.out.println("I win!");
            } else if (victory == 2) {
                System.out.println("Congratulations! You win!");
            } else if (victory == 3) {
                System.out.println("It's a tie!");
            } else {
                exit();
            }
        } else {
            exit();
        }
    }
    
    public static void compIntel() {
        
    }
    
    public static void player() {
        String reply;
        boolean valid;
        
        while (victory == 0) {
            System.out.println("Player X, enter your selection.");
            reply = input.nextLine().toLowerCase().replaceAll("[^abc123]", "");

            valid = false;

            while (!valid) {
                if (reply.equals("a1") && grid[0][0].equals(" ")) {
                    grid[0][0] = "X";
                    valid = true;
                    printGrid();
                } else if (reply.equals("a2") && grid[1][0].equals(" ")) {
                    grid[1][0] = "X";
                    valid = true;
                    printGrid();
                } else if (reply.equals("a3") && grid[2][0].equals(" ")) {
                    grid[2][0] = "X";
                    valid = true;
                    printGrid();
                } else if (reply.equals("b1") && grid[0][1].equals(" ")) {
                    grid[0][1] = "X";
                    valid = true;
                    printGrid();
                } else if (reply.equals("b2") && grid[1][1].equals(" ")) {
                    grid[1][1] = "X";
                    valid = true;
                    printGrid();
                } else if (reply.equals("b3") && grid[2][1].equals(" ")) {
                    grid[2][1] = "X";
                    valid = true;
                    printGrid();
                } else if (reply.equals("c1") && grid[0][2].equals(" ")) {
                    grid[0][2] = "X";
                    valid = true;
                    printGrid();
                } else if (reply.equals("c2") && grid[1][2].equals(" ")) {
                    grid[1][2] = "X";
                    valid = true;
                    printGrid();
                } else if (reply.equals("c3") && grid[2][2].equals(" ")) {
                    grid[2][2] = "X";
                    valid = true;
                    printGrid();
                } else {
                    valid = false;
                    System.out.println("I'm sorry, that's not a valid answer. Here's the grid, please try again:");
                    printGrid();
                    System.out.println("Player X, enter your selection.");
                    reply = input.nextLine().toLowerCase().replaceAll("[^abc123]", "");
                }
            }
            
            checkVictory();
            
            if (victory == 0) {
                System.out.println("Player O, enter your selection.");
                reply = input.nextLine().toLowerCase().replaceAll("[^abc123]", "");

                valid = false;

                while (!valid) {
                    if (reply.equals("a1") && grid[0][0].equals(" ")) {
                        grid[0][0] = "O";
                        valid = true;
                        printGrid();
                    } else if (reply.equals("a2") && grid[1][0].equals(" ")) {
                        grid[1][0] = "O";
                        valid = true;
                        printGrid();
                    } else if (reply.equals("a3") && grid[2][0].equals(" ")) {
                        grid[2][0] = "O";
                        valid = true;
                        printGrid();
                    } else if (reply.equals("b1") && grid[0][1].equals(" ")) {
                        grid[0][1] = "O";
                        valid = true;
                        printGrid();
                    } else if (reply.equals("b2") && grid[1][1].equals(" ")) {
                        grid[1][1] = "O";
                        valid = true;
                        printGrid();
                    } else if (reply.equals("b3") && grid[2][1].equals(" ")) {
                        grid[2][1] = "O";
                        valid = true;
                        printGrid();
                    } else if (reply.equals("c1") && grid[0][2].equals(" ")) {
                        grid[0][2] = "O";
                        valid = true;
                        printGrid();
                    } else if (reply.equals("c2") && grid[1][2].equals(" ")) {
                        grid[1][2] = "O";
                        valid = true;
                        printGrid();
                    } else if (reply.equals("c3") && grid[2][2].equals(" ")) {
                        grid[2][2] = "O";
                        valid = true;
                        printGrid();
                    } else {
                        valid = false;
                        System.out.println("I'm sorry, that's not a valid answer. Here's the grid, please try again:");
                        printGrid();
                        System.out.println("Player O, enter your selection.");
                        reply = input.nextLine().toLowerCase().replaceAll("[^abc123]", "");
                    }
                }
            }
            
            checkVictory();
        }
        
        if (victory == 1) {
            System.out.println("Congratulations! Player X has won!");
        } else if (victory == 2) {
            System.out.println("Congratulations! Player O has won!");
        } else if (victory == 3) {
            System.out.println("It's a tie!");
        } else {
            exit();
        }
        
    }
    
    public static void checkVictory() {
        String a1 = grid[0][0];
        String a2 = grid[1][0];
        String a3 = grid[2][0];
        
        String b1 = grid[0][1];
        String b2 = grid[1][1];
        String b3 = grid[2][1];
        
        String c1 = grid[0][2];
        String c2 = grid[1][2];
        String c3 = grid[2][2];
        
        if (a1.equals(a2) && a2.equals(a3)) {
            if (a1.equals("X")) {
                victory = 1;
            } else if (a1.equals("O")) {
                victory = 2;
            }
        } else if (b1.equals(b2) && b2.equals(b3)) {
            if (b1.equals("X")) {
                victory = 1;
            } else if (b1.equals("O")) {
                victory = 2;
            }
        } else if (c1.equals(c2) && c2.equals(c3)) {
            if (c1.equals("X")) {
                victory = 1;
            } else if (c1.equals("O")) {
                victory = 2;
            }
        } else if (a1.equals(b1) && b1.equals(c1)) {
            if (a1.equals("X")) {
                victory = 1;
            } else if (a1.equals("O")) {
                victory = 2;
            }
        } else if (a2.equals(b2) && b2.equals(c2)) {
            if (a2.equals("X")) {
                victory = 1;
            } else if (a2.equals("O")) {
                victory = 2;
            }
        } else if (a3.equals(b3) && b3.equals(c3)) {
            if (a3.equals("X")) {
                victory = 1;
            } else if (a3.equals("O")) {
                victory = 2;
            }
        } else if (a1.equals(b2) && b2.equals(c3)) {
            if (a1.equals("X")) {
                victory = 1;
            } else if (a1.equals("O")) {
                victory = 2;
            }
        } else if (a3.equals(b2) && b2.equals(c1)) {
            if (a3.equals("X")) {
                victory = 1;
            } else if (a3.equals("O")) {
                victory = 2;
            }
        }

        int fillCount = 0;

        for (String[] array : grid) {
            for (String element : array) {
                if (!element.equals(" ")) {
                    fillCount++;
                }
            }
        }

        if (fillCount == 9) {
            victory = 3;
        }
    }
    
    public static void printGrid() {
        System.out.println("  A   B   C\n" +
            "1 " + grid[0][0] + " | " + grid[0][1] + " | " + grid[0][2] + "  \n" +
            " ---+---+---\n" +
            "2 " + grid[1][0] + " | " + grid[1][1] + " | " + grid[1][2] + "  \n" +
            " ---+---+---\n" +
            "3 " + grid[2][0] + " | " + grid[2][1] + " | " + grid[2][2]);
        
    }
    
    public static void exit() {
        System.out.println("I'm sorry, but it appears that I can't code. My sincerest apologies. You will now be redirected to the "
                + "afterlife. Goodbye!");
        System.exit(0);
    }
    
}
