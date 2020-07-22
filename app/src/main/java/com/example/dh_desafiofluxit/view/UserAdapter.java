package com.example.dh_desafiofluxit.view;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.dh_desafiofluxit.R;
import com.example.dh_desafiofluxit.databinding.CeldaUserBinding;
import com.example.dh_desafiofluxit.model.User;
import com.example.dh_desafiofluxit.util.Utils;

import java.util.List;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class UserAdapter extends RecyclerView.Adapter<UserAdapter.UserViewHolder> {

    private List<User> userList;
    private UserAdapterListener listener;

    @NonNull
    @Override
    public UserViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.celda_user, parent, false);

        return new UserViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull UserViewHolder holder, int position) {
        User user = userList.get(position);
        holder.onBind(user);
    }

    @Override
    public int getItemCount() {
        return userList.size();
    }

    public void addList(List<User> users){
        this.userList.addAll(users);
        notifyDataSetChanged();
    }



    public class UserViewHolder extends RecyclerView.ViewHolder{

        private ImageView imagen;
        private TextView nombre;

        public UserViewHolder(@NonNull View itemView) {
            super(itemView);
            imagen = itemView.findViewById(R.id.celdaUserImageView);
            nombre = itemView.findViewById(R.id.celdaUserTextViewNombre);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    User user = userList.get(getAdapterPosition());
                    listener.onClickUserAdapter(user);
                }
            });
        }

        public void onBind(User user){
            nombre.setText(user.getName().getTitle() + " " + user.getName().getFirst() + " " + user.getName().getLast());
            Glide.with(itemView)
                    .setDefaultRequestOptions(Utils.requestOptionsCircularProgressBar(itemView.getContext()))
                    .load(user.getPicture().getThumbnail())
                    .into(imagen);
        }
    }

    public interface UserAdapterListener{
        void onClickUserAdapter(User user);
    }

}
