package model.board;

import model.gem.*;

public class Board {
    private final int numSquares = 10;
    private final int numHalfCircles = 2;
    private final int numBigGems = 2;
    private final int numSmallGems = 50;
    private Cell[] cells;

    public int getNumSquares() {
        return numSquares;
    }

    public int getNumHalfCircles() {
        return numHalfCircles;
    }

    public int getNumSmallGems() {
        return numSmallGems;
    }

    public int getNumBigGems() {
        return numBigGems;
    }

    public Board() {
        initializeCells();
        addGemsToCells();
    }

    private void initializeCells() {
        cells = new Cell[this.numSquares + this.numHalfCircles];
        cells[0] = new HalfCircle(0);
        cells[(this.numSquares + this.numHalfCircles) / 2] = new HalfCircle((this.numSquares + this.numHalfCircles) / 2);
    }

    private void addGemsToCells() {

        Gem bigGem1 = new BigGem();
        this.cells[0].addGem(bigGem1);

        for (int i = 1; i <= numSquares / 2; i++) {
            this.cells[i] = new Square(i);
            for (int j = 0; j < this.numSmallGems/10; j++) {
                Gem smallGem = new SmallGem();
                this.cells[i].addGem(smallGem);
            }
        }

        Gem bigGem2 = new BigGem();
        this.cells[(this.numSquares + this.numHalfCircles) / 2].addGem(bigGem2);

        for (int i = numSquares / 2 + 2; i <= numSquares + numHalfCircles - 1; i++) {
            this.cells[i] = new Square(i);
            for (int j = 0; j < this.numSmallGems/10; j++) {
                Gem smallGem = new SmallGem();
                this.cells[i].addGem(smallGem);
            }
        }
    }

    public Cell[] getCells() {
        return cells;
    }

    public Cell getNextCellCounterClockwise(Cell cell) {
        int position = cell.getLocation();
        int lastPosition = this.numSquares + this.numHalfCircles - 1;
        return this.cells[position == 0 ? lastPosition : position - 1];
    }

    public Cell getNextCellClockwise(Cell cell) {
        int position = cell.getLocation();
        int lastPosition = this.numSquares + this.numHalfCircles - 1;
        return this.cells[position == lastPosition ? 0 : position + 1];
    }

    public boolean endGame(){
        Cell[] cells = this.getCells();

        for (Gem gem :cells[0].getGemList()){
            if (gem instanceof BigGem){
                return false;
            }
        }

        for (Gem gem :cells[6].getGemList()){
            if (gem instanceof BigGem){
                return false;
            }
        }

        return true;
    }

}
