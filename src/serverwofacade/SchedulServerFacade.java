package serverwofacade;

public class SchedulServerFacade {
    private static ScheduleServer server = null;
    private static SchedulServerFacade myFacade = null;

    private SchedulServerFacade(){

    }
    public static SchedulServerFacade getSchedulServerFacade(){
        if (myFacade == null){
            myFacade = new SchedulServerFacade();
        }
        return myFacade;
    }
    public void startServer(){
        server = new ScheduleServer();
        server.startBooting();
        server.readSystemConfigFile();
        server.init();
        server.initializeContext();
        server.initializeListeners();
        server.createSystemObjects();
        System.out.println("Start working......");
    }
    public void stopServer(){
        if (server == null){
            System.out.println("Server hasn't been started");
        }
        else{
            server.releaseProcesses();
            server.destory();
            server.destroySystemObjects();
            server.destoryListeners();
            server.destoryContext();
            server.shutdown();
        }
    }
}
