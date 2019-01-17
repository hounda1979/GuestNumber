package tw.hd.com.guestnumber;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private List<Icom_main> icoms;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RecyclerView recyclerView = findViewById(R.id.recycler);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new GridLayoutManager(this,3));
        //Adapter
        icoms = new ArrayList<>();
        String[] icomarray = {"1A2B"};
        icoms.add(new Icom_main(icomarray[0],R.drawable.guestnumber));
        IconAdapter adapter = new IconAdapter();

        recyclerView.setAdapter(adapter);

    }

    public class IconAdapter extends  RecyclerView.Adapter<IconAdapter.IconHolder> {
        @NonNull
        @Override
        public IconHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
            View view = getLayoutInflater().inflate(R.layout.main_icon,viewGroup,false);
            return new IconHolder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull IconHolder holder, int position) {
            final Icom_main icom_main = icoms.get(position);
            holder.nameText.setText(icom_main.getName());
            holder.icomImage.setImageResource(icom_main.getIcon());
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    itemClick(icom_main);
                }
            });


        }

        @Override
        public int getItemCount() {
            return icoms.size();
        }

        public class IconHolder extends RecyclerView.ViewHolder{
            ImageView icomImage;
            TextView nameText;

            public IconHolder(@NonNull View itemView) {
                super(itemView);
                icomImage = itemView.findViewById(R.id.image_icom);
                nameText = itemView.findViewById(R.id.name_icom);

            }
        }
    }

    private void itemClick(Icom_main icom_main) {
        switch (icom_main.getIcon()){
            case R.drawable.guestnumber:
                startActivity(new Intent(this,GuestActivity.class));
                break;
        }
    }
}
