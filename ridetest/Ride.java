
package com.mycompany.ridetest;
public abstract class Ride {
    
    private String PickupPoint;
    private String DropPoint;
    private String Name;
    
    
    public Ride(String PP ,String DP , String N){
        this.PickupPoint = PP;
        this.DropPoint = DP;
        this.Name = N;
    }
    public abstract double CalculateDistance(double p1 , double p2 , double[]x , double[]y);
    
    public abstract double  CalculateFare(double distance);
        
}

class CarAC extends Ride{
    public CarAC(String PickupPoint , String DropPoint , String Name){
        super(PickupPoint ,DropPoint , Name);
       
    }
    
    public double CalculateDistance(double p1 , double p2 , double[]x , double[]y){
        
                     double distancex = x[(int)p1]- x[(int)p2];
                     double distancey = y[(int)p1] - y[(int)p2];
                     
                     double finaldist = Math.sqrt((distancex * distancex) + (distancey * distancey));
                     return finaldist;
    }
                     
                     
    
    public double CalculateFare(double distance){
        return 250* distance;
    }
        
}

class CarNonAC extends Ride{
    public CarNonAC(String PickupPoint , String DropPoint , String Name){
        super(PickupPoint ,DropPoint , Name);}
        
    public double CalculateDistance(double p1 , double p2 , double[]x , double[]y){
        
                     double distancex = x[(int)p1]- x[(int)p2];
                     double distancey = y[(int)p1] - y[(int)p2];
                     
                     double finaldist = Math.sqrt((distancex * distancex) + (distancey * distancey));
                     return finaldist;
    }
    
    public double CalculateFare(double distance){
        return 200* distance;
    }
        
}

class Bike extends Ride {
     public Bike(String PickupPoint , String DropPoint , String Name){
        super(PickupPoint ,DropPoint , Name);}
     
     public double CalculateDistance(double p1 , double p2 , double[]x , double[]y){
        
                     double distancex = x[(int)p1]- x[(int)p2];
                     double distancey = y[(int)p1] - y[(int)p2];
                     
                     double finaldist = Math.sqrt((distancex * distancex) + (distancey * distancey));
                     return finaldist;
    }
     
     public double CalculateFare(double distance){
        return 150 * distance;
    }
}

class Rikshaw extends Ride {
    public Rikshaw(String PickupPoint , String DropPoint , String Name){
        super(PickupPoint ,DropPoint , Name);}
    
    public double CalculateDistance(double p1 , double p2 , double[]x , double[]y){
        
                     double distancex = x[(int)p1]- x[(int)p2];
                     double distancey = y[(int)p1] - y[(int)p2];
                     
                     double finaldist = Math.sqrt((distancex * distancex) + (distancey * distancey));
                     return finaldist;
    }
    
    public double CalculateFare(double distance){
        return 120 * distance;
    }
     
}