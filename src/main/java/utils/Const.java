package utils;

public class Const {

    private int getEnvType(){
        int iIndex = 0;
        String envType =System.getProperty("envType");
        if(envType.equals("Stage888")){iIndex = 0;}
        if(envType.equals("StageP2")){iIndex = 1;}
        if(envType.equals("Stage2559")){iIndex = 2;}
        if(envType.equals("Prod2559")){iIndex = 3;}

        return iIndex;
    }

    public String[][][] sSettings = {
            {{"https://888.stagecarrierzone.com/portal/", "qatest-888-11111616@adudyak.hostopia.com","Temp1234%", "Stage888", "fax"}},
            {{"https://p2.stagecarrierzone.com/portal/", "mdiakonova-2252020@ashustikov.hostopia.com","Temp1234%", "StageP2", "fax"}},
            {{"https://2559.stagecarrierzone.com/portal/", "qatest-rp-2559-24112021@ashustikov.hostopia.com","Temp1234%", "Stage2559", "fax"}},
            {{"https://p2.hostopia.com/portal/", "qatest-rparkhomenko-2559-10192021-dk@ashustikov.hostopia.com","Temp1234%", "Prod2559", "fax"}},

    };

    //public  int iIndex = getEnvType();
    public  int iIndex = 3;
    public String BASE_URL = sSettings[iIndex][0][0];
    public String USERNAME = sSettings[iIndex][0][1];
    public String PASSWORD = sSettings[iIndex][0][2];
    public String sEnvType = sSettings[iIndex][0][3];
    public String FAX_URL = sSettings[iIndex][0][4];

    /************* Browsers ***************************/
//    public static final String BROWSER = "chrome";
    public static final String BROWSER = "firefox";
//    public static final String BROWSER = "safari";
//


    /***** Inputs *****/
    public static final String VALID_EMAIL = "qatest-888-11111616@adudyak.hostopia.com";
    public static final String RANDOM_USERNAME = "random username";
    public static final String RANDOM_PASSWORD = "password";
    public static final String ENTER_USERNAME_AND_PASSWORD_ERROR = "Please enter username and password";
    public static final String INCORRECT_USERNAME_OR_PASSWORD = "Incorrect username or password.";
    public static final String NEW_PASSWORD = "Temp12345%";



    /***** THREAD SLEEP VALUES FOR MAKING PAUSES *****/

    public static final int VERY_SHORT_SLEEP = 500;
    public static final int SHORT_SLEEP = 1000;
    public static final int NORMAL_SLEEP = 3000;
    public static final int LONG_SLEEP = 5000;
    public static final int VERY_LONG_SLEEP = 7000;
    public static final int VERY_VERY_LONG_SLEEP = 13000;
}
