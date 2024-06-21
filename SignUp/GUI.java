package javaSwing;

public class GUI {
    public static void main(String[] args) {
        String filepath = "Joe Hisaishi_MerryGoRoundofLife.wav";
        
        musicPlayer player = new musicPlayer();
        player.plyMusic(filepath);
        
        new SignUpGUI(player);
    }
}
