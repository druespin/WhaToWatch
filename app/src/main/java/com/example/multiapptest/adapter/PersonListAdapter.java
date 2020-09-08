package com.example.multiapptest.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.multiapptest.R;
import com.example.multiapptest.data.Person;
import com.example.multiapptest.util.ImageLoader;

import java.util.List;

public class PersonListAdapter extends RecyclerView.Adapter<PersonListAdapter.PersonViewHolder> {

    private List<Person> persons;

    public PersonListAdapter(List<Person> persons) {
        this.persons = persons;
    }

    @NonNull
    @Override
    public PersonListAdapter.PersonViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.movie_item, parent,false);
        return new PersonListAdapter.PersonViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PersonListAdapter.PersonViewHolder holder, int position) {
        Person person = persons.get(position);
        holder.name.setText(person.getName());
        holder.profession.setText(person.getProfession());
        ImageLoader.loadImage(person.getPhoto(), holder.photo);
    }

    @Override
    public int getItemCount() {
        return persons.size();
    }

    static class PersonViewHolder extends RecyclerView.ViewHolder {
        ImageView photo;
        TextView name, profession;

        public PersonViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.movie_title);
            profession = itemView.findViewById(R.id.vote);
            photo = itemView.findViewById(R.id.poster);
        }

    }
}
