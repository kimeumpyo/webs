package exam02.member;

public class ServiceManager {

    private static ServiceManager instance;

    private ServiceManager(){}

    public MemberDao memberDao(){

//        return new MemberDao();
    return new CachedMemberDao();

    }

    public JoinService joinService(){

        return new JoinService(memberDao());
    }

    public MemberListService listService(){

        return new MemberListService(memberDao());
    }

    public static ServiceManager getInstance(){
        if(instance == null){
            instance = new ServiceManager();
        }
        return instance;
    }
}
