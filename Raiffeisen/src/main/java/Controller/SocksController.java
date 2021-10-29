package Controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.print.DocFlavor;
import java.util.List;

@RestController
public class SocksController {
    private List<String> socks;
    @GetMapping("/api/socks")
    public String getCountSocks(
            @RequestParam(value = "color") String color,
            @RequestParam(value= "operation") String operation,
            @RequestParam(value= "cottonPart") String cottonPart ) {
        return "getCountSocks";
    }
    @PutMapping("/api/socks/income")
    public ResponseEntity<?> postIncomeSocks(
            @RequestParam(value = "color") String color,
            @RequestParam(value= "cottonPart") String cottonPart,
            @RequestParam(value= "quantity") String quantity ) {
        final boolean addSocks = socks.add(color);
        return addSocks
                ? new ResponseEntity<String>(HttpStatus.OK)
                : new ResponseEntity<String>(HttpStatus.NOT_MODIFIED);
    }
    @PutMapping("/api/socks/outcome")
    public ResponseEntity<?> postOutcomeSocks(
            @RequestParam(value = "color") String color,
            @RequestParam(value= "cottonPart") String cottonPart,
            @RequestParam(value= "quantity") String quantity ) {
        final boolean addSocks = socks.add(color);
        return addSocks
                ? new ResponseEntity<String>(HttpStatus.OK)
                : new ResponseEntity<String>(HttpStatus.NOT_MODIFIED);
    }
}