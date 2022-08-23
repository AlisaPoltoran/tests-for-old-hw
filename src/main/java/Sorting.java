public class Sorting {
        public static void main(String[] args) {

            int[][] teams = {
                    {45, 31, 24, 22, 20, 17, 14, 13, 12, 10},
                    {31, 18, 15, 12, 10, 8, 6, 4, 2, 1},
                    {51, 30, 10, 9, 8, 7, 6, 5, 2, 1},
            };

            int[] nationalTeam = formNationalTeam(teams);
            printArray(nationalTeam);
        }

        public static int[] merge(int[] firstTeam, int[] secondTeam) {
            int[] topTen = new int[firstTeam.length];
            int counterFirstTeam = 0;
            int counterSecondTeam = 0;
            int counterTopTenFromTwo = 0;

            for (int i = 0; i < firstTeam.length; i++) {
                if (counterFirstTeam == firstTeam.length) {
                    topTen[counterTopTenFromTwo] = secondTeam[counterSecondTeam];
                    counterSecondTeam += 1;
                } else if (counterSecondTeam == secondTeam.length) {
                    topTen[counterTopTenFromTwo] = firstTeam[counterFirstTeam];
                    counterFirstTeam += 1;
                } else if (firstTeam[counterFirstTeam] >= secondTeam[counterSecondTeam]) {
                    topTen[counterTopTenFromTwo] = firstTeam[counterFirstTeam];
                    counterFirstTeam += 1;

                } else {
                    topTen[counterTopTenFromTwo] = secondTeam[counterSecondTeam];
                    counterSecondTeam += 1;

                }
                counterTopTenFromTwo += 1;
            }
            return topTen;
        }

        public static void printArray(int[] array) {
            for (int j : array) {
                System.out.print(j + " ");
            }
        }

        public static int[] formNationalTeam(int[][] teams) {
            int[] nationalTeam = teams[0];
            for (int i = 1; i < teams.length; i++) {
                nationalTeam = merge(nationalTeam, teams[i]);
            }
            return nationalTeam;
        }
    }

