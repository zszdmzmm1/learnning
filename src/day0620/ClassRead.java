package day0620;


import com.google.gson.Gson;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ClassRead {
    public static void main(String[] args) throws IOException {
        Player player1 = new Player(1, "Ted");
        Player player2 = new Player(2, "Lily");
        Player player3 = new Player(3, "Barney");
        Player player4 = new Player(4, "Robin");

        List<Player> playerList = new ArrayList<>();
        playerList.add(player1);
        playerList.add(player2);
        playerList.add(player3);
        playerList.add(player4);

        Gson s = new Gson();
        String info = s.toJson(playerList);
        byte[] infoBity = info.getBytes();
        File f = new File("D:\\a.doc.2\\Java\\course\\learning\\src\\day0620\\playinfomation.json");
        if (!f.exists()) {
            f.createNewFile();
        }
        OutputStream ouputStream = new FileOutputStream(f);
        ouputStream.write(infoBity, 0, info.length());
        ouputStream.flush();
        ouputStream.close();

        InputStream inputStream = new FileInputStream(f);
        byte[] temp = new byte[(int)f.length()];
        inputStream.read(temp, 0, (int) f.length());
        String infoString = new String(temp);
        /*String infoString = new String(temp);
        for (byte b : temp) {
            infoString += (char) b;
        }*/
        System.out.println(infoString);
        List<Player> list = s.fromJson(infoString, List.class);
        System.out.println(list);
    }
}

class Player {
    private int id;
    private String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Player(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Player{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
