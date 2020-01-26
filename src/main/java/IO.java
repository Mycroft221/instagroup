import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.io.IOException;

public class IO {
    public static void main(String[] args) {
        FirebaseOptions options = null;
        options = new FirebaseOptions.Builder()
                .setCredentials(GoogleCredentials.newBuilder().build())
                .setDatabaseUrl("https://direct-chess-137822.firebaseio.com/")
                .build();

        FirebaseApp.initializeApp(options);
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("message");

        User user = new User("Nate", "nate@umn.edu");
        myRef.child("users").child("first").setValue(user, null);
        System.out.println(myRef.child("users").);
    }

}
