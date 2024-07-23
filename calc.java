public class calc {
    static int monkeyTotal = 0;

    public void roundCost(String round, int cash){
        int roundInt = Integer.valueOf(round);
        //amount of cash if no money is spent
        int roundTarget = monkeyTotal+roundIndex(roundInt)-cash;
        System.out.println("monkeytotal:"+monkeyTotal+"roundInt "+roundIndex(roundInt)+"cash "+cash);


        int roundFinal = 0;

        //goes through the list of rounds until it finds a round with enough cash to
        for(int i = roundInt; roundTarget>=roundIndex(i); i++){
            roundFinal = i;
            }
        System.out.println("round "+roundFinal);
        System.out.println("round cash:"+roundIndex(roundFinal));
        System.out.println("target"+roundTarget);
        }

        //it just adds up all the costs tbf
    public static void monkeyCost(int top, int middle, int bottom, int index){
        database db = new database();

        //variables
        int topPrice = 0;
        int middlePrice = 0;
        int bottomPrice = 0;
        //error handler
        if(top>0&&top<=6){
            int[] topSelected = db.tPaths[top];
            topPrice = topSelected[index];
            System.out.println(topPrice);
        }
        if (middle>0&&middle<=6){
            int[] middleSelected = db.tPaths[middle];
            middlePrice = middleSelected[index];
        }
        if(bottom>0&&bottom<=6){
            int[] bottomSelected = db.tPaths[bottom];
            bottomPrice = bottomSelected[index];
            System.out.println(bottomPrice);
        }

        int total = topPrice+middlePrice+bottomPrice;
        System.out.println(total);
        monkeyTotal =+ total;

    }

    public static int roundIndex(int i){
        database db = new database();
        int cashIndex = db.roundCash[i];
        return cashIndex;
    }
}
