
import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public enum Cursuri implements Serializable {
	
ENGLEZA,
FRANCEZA,
SPANIOLA,
ROMANA,
MATEMATICA,
INFORMATICA,
FIZICA,
CHIMIE,
ISTORIE,
GEOGRAFIE;


public String toString(){
   switch(this){
        case ENGLEZA :
            return "ENGLEZA";
        case FRANCEZA :
            return "FRANCEZA";
        case SPANIOLA :
            return "SPANIOLA";
        case ROMANA :
            return "ROMANA";
        case MATEMATICA :
            return "MATEMATICA";
        case INFORMATICA :
            return "INFORMATICA";
        case FIZICA :
            return "FIZICA";
        case CHIMIE :
            return "CHIMIE";
        case ISTORIE :
            return "ISTORIE";
        case GEOGRAFIE :
            return "GEOGRAFIE";
            
        }
        return null;
    }


}