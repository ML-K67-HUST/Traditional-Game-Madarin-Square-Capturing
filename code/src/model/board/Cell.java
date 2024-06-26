package model.board;


import java.util.ArrayList;
import java.util.List;

import model.gem.*;

public abstract class Cell{
    private int location;
    private List<Gem> gemList = new ArrayList<Gem>();

    public Cell(int location) {
        this.location = location;
    }

    public int getLocation() {
        return location;
    }

    public List<Gem> getGemList() {
        return gemList;
    }

    public void addGem(Gem gem) {  // polymorphism for add or declare
        this.gemList.add(gem);
    }

    public boolean isEmpty() {
        return this.getGemList().size() == 0;
    }

    public void setEmpty(){
        this.gemList.clear();
    }
    public String seeDetails() {
        StringBuffer gemDetails = new StringBuffer();
        for(Gem gem:this.gemList) {
            gemDetails.append(gem);
        }
        return(
                 "-"+"Cell " + this.getClass().getSimpleName() +
                        ", number of gems: " + this.getGemList().size() +
                        ", gem list: " + gemDetails+"\n"
                );
    }

    public int getNumberOfBigGems(){
        int numberOfBigGems = 0;
        for (Gem gem : this.gemList){
            if (gem instanceof BigGem){
                numberOfBigGems++;
            }
        }
        return numberOfBigGems;
    }
    public int getNumberOfSmallGems(){
        int numberOfSmallGems = 0;
        for (Gem gem : this.gemList){
            if (gem instanceof SmallGem){
                numberOfSmallGems++;
            }
        }
        return numberOfSmallGems;
    }

    public Cell copyCell(){
        // Cell newCell = new Cell(cell.getLocation(), cell.getNumberOfGems()); -> Error because Cell is abstract
        // Cell newCell; can not do because newCell is not initialized from square, halfcircle, circle
        Cell newCell=null;
        
        if (this instanceof Square){
            newCell = new Square(this.getLocation());
              //upcasting
            for (int i=0; i<this.getNumberOfSmallGems();i++){
            newCell.addGem(new SmallGem());
            }
            return newCell;
        }
        else if (this instanceof HalfCircle){
            newCell = new HalfCircle(this.getLocation());
            for (int i=0; i<this.getNumberOfSmallGems();i++){
                newCell.addGem(new SmallGem());
            }
            for (int i=0; i<this.getNumberOfBigGems();i++){
                newCell.addGem(new BigGem());
            }
            return newCell;

        }
        return null;
    }

}