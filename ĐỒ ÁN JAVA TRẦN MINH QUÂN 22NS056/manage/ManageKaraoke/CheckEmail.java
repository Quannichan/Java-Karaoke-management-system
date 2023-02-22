package ManageKaraoke;

import java.util.ArrayList;

public class CheckEmail {
    public boolean CheckEmail(String insertinto) {
        String text = insertinto;
        int count = 0;
        boolean check;
        ArrayList<String> b = new ArrayList<String>();
        b.add("@");
        b.add(".");
        for (int i = 0; i < b.size(); i++) {
            if (text.contains(b.get(i))) {
                count = count + 1;
            }
        }
        if (count == b.size()) {
            return true;
        } else {
            return false;
        }
    }
}
