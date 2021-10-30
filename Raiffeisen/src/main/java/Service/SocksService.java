package Service;

import Model.Socks;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class SocksService {
    private ArrayList<Socks> socks= new ArrayList<Socks>();
    public int getPairsSocks(String color, String operation, String cottonPart){
        int countSocks=0;

        return countSocks;
    }
    public void addSocks(String color, String cottonPart, String quantity) {
        socks.add(new Socks(color,cottonPart,quantity));
    }
    public void deleteSocks(String color, String cottonPart, String quantity){
        Socks removableSock= new Socks(color,cottonPart,quantity);
        socks.remove(removableSock);
    }
}
