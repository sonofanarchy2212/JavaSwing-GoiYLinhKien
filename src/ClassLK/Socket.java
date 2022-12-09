
package ClassLK;


public class Socket {

    @Override
    public String toString() {
      return Socket;
    }
    private int MaSocket;
    private String Socket;

    public Socket(int MaSocket, String Socket) {
        this.MaSocket = MaSocket;
        this.Socket = Socket;
    }
    public Socket(Socket s){
        this.MaSocket=s.getMaSocket();
        this.Socket = s.getSocket();
    }
    public Socket(){
        MaSocket = 0;
        Socket = new String();
    }

    public int getMaSocket() {
        return MaSocket;
    }

    public void setMaSocket(int MaSocket) {
        this.MaSocket = MaSocket;
    }





    public String getSocket() {
        return Socket;
    }

    public void setSocket(String Socket) {
        this.Socket = Socket;
    }

 
    
}
