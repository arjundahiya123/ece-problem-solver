package ece2238.eceproblemsolver;

public class LogicGates {

    public static ComplexNumber[][] getLogicGate(char x){
        ComplexNumber[][] logicGate = null;

        switch(x){
            case 'I':
            case 'C':
                logicGate = new ComplexNumber[][]{{new ComplexNumber(1,0),
                        new ComplexNumber(0,0)}, {new ComplexNumber(0,0),
                        new ComplexNumber(1,0)}};
//                System.out.println(Arrays.deepToString(logicGate));
                break;
            case 'X':
                logicGate = new ComplexNumber[][]{{new ComplexNumber(0,0),
                        new ComplexNumber(1,0)}, {new ComplexNumber(1,0),
                        new ComplexNumber(0,0)}};
//                System.out.println(Arrays.deepToString(logicGate));
                break;
            case 'Y':
                logicGate = new ComplexNumber[][]{{new ComplexNumber(0,0),
                        new ComplexNumber(0,-1)}, {new ComplexNumber(0,1),
                        new ComplexNumber(0,0)}};
//                System.out.println(Arrays.deepToString(logicGate));
                break;
            case 'Z':
                logicGate = new ComplexNumber[][]{{new ComplexNumber(1,0),
                        new ComplexNumber(0,0)}, {new ComplexNumber(0,0),
                        new ComplexNumber(-1,0)}};
//                System.out.println(Arrays.deepToString(logicGate));
                break;
            case 'H':
                logicGate = new ComplexNumber[][]{{new ComplexNumber(1/Math.sqrt(2),0),
                        new ComplexNumber(1/Math.sqrt(2),0)}, {new ComplexNumber(1/Math.sqrt(2),0),
                        new ComplexNumber(-1/Math.sqrt(2),0)}};
//                System.out.println(Arrays.deepToString(logicGate));
                break;
            case 'P':
                logicGate = new ComplexNumber[][]{{new ComplexNumber(1,0),
                        new ComplexNumber(0,0)}, {new ComplexNumber(0,0),
                        new ComplexNumber(0,1)}};
//                System.out.println(Arrays.deepToString(logicGate));
                break;
            default:
                System.out.println("Error: No valid Logic Gate Entered");
        }

        return logicGate;
    }

    public static ComplexNumber[][] getStage(ComplexNumber[][] level1, ComplexNumber[][] level2, boolean isControl){
        ComplexNumber[][] stageLogicGate = new ComplexNumber[4][4];

        if(isControl){
            stageLogicGate = new ComplexNumber[][]{{new ComplexNumber(1,0), new ComplexNumber(0,0),
                    new ComplexNumber(0,0), new ComplexNumber(0,0)},
                    {new ComplexNumber(0,0), new ComplexNumber(1,0), new ComplexNumber(0,0),
                            new ComplexNumber(0,0)}, {new ComplexNumber(0,0),
                    new ComplexNumber(0,0), null, null},
                    {new ComplexNumber(0,0), new ComplexNumber(0,0), null, null}};

            for(int row = 0; row < 2; row++){
                for(int col = 0; col < 2; col++){
                    stageLogicGate[row+2][col+2] = level2[row][col];
                }
            }
        }
        else {

            for (int lv1Row = 0; lv1Row < 2; lv1Row++) {
                for (int lv1Col = 0; lv1Col < 2; lv1Col++) {
                    for (int lv2Row = 0; lv2Row < 2; lv2Row++) {
                        for (int lv2Col = 0; lv2Col < 2; lv2Col++) {

                            int stageLogicGateRow = 2 * lv1Row + lv2Row;
                            int stageLogicGateCol = 2 * lv1Col + lv2Col;
                            stageLogicGate[stageLogicGateRow][stageLogicGateCol] = level1[lv1Row][lv1Col].multiply(level2[lv2Row][lv2Col]);
                        }
                    }
                }
            }

        }

//        for (int i = 0; i < 2; i++) {
//            for (int j = 0; j < 2; j++) {
//                // Iterate within each block to fill the 4x4 stageLogicGate matrix
//                for (int k = 0; k < 2; k++) {
//                    for (int l = 0; l < 2; l++) {
//                        // Calculate the correct index in the 4x4 matrix
//                        int row = i * 2 + k;
//                        int col = j * 2 + l;
//                        // Fill the stageLogicGate matrix using multiplication of level1 and level2
//                        stageLogicGate[row][col] = level1[i][j].multiply(level2[k][l]);
//                    }
//                }
//            }
//        }

//        stageLogicGate[0][0] = level1[0][0].multiply(level2[0][0]);
//        stageLogicGate[0][1] = level1[0][0].multiply(level2[0][1]);
//        stageLogicGate[1][0] = level1[0][0].multiply(level2[1][0]);
//        stageLogicGate[1][1] = level1[0][0].multiply(level2[1][1]);
//
//        stageLogicGate[0][2] = level1[0][1].multiply(level2[0][0]);
//        stageLogicGate[0][3] = level1[0][1].multiply(level2[0][1]);
//        stageLogicGate[1][2] = level1[0][1].multiply(level2[1][0]);
//        stageLogicGate[1][3] = level1[0][1].multiply(level2[1][1]);
//
//        stageLogicGate[2][0] = level1[1][0].multiply(level2[0][0]);
//        stageLogicGate[2][1] = level1[1][0].multiply(level2[0][1]);
//        stageLogicGate[3][0] = level1[1][0].multiply(level2[1][0]);
//        stageLogicGate[3][1] = level1[1][0].multiply(level2[1][1]);
//
//        stageLogicGate[2][2] = level1[1][1].multiply(level2[0][0]);
//        stageLogicGate[2][3] = level1[1][1].multiply(level2[0][1]);
//        stageLogicGate[3][2] = level1[1][1].multiply(level2[1][0]);
//        stageLogicGate[3][3] = level1[1][1].multiply(level2[1][1]);


        return stageLogicGate;
    }

    public String toString(ComplexNumber[][] matrix) {
        StringBuilder sb = new StringBuilder();
        sb.append("[\n");
        for (ComplexNumber[] row : matrix) {
            sb.append("  [");
            for (int j = 0; j < row.length; j++) {
                sb.append(row[j]);
                if (j < row.length - 1) {
                    sb.append(", ");
                }
            }
            sb.append("],\n");
        }
        sb.append("]");
        return sb.toString();
    }

}
