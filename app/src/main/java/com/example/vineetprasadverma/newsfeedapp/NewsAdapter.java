package com.example.vineetprasadverma.newsfeedapp;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class NewsAdapter extends ArrayAdapter<News> {

    /**
     * @param context is the current context i.e. the activity in which adapter is beimg created.
     * @param newsList   is the news which is to be displayed.
     */
    public NewsAdapter(Context context, List<News> newsList) {
        super(context, 0, newsList);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        //Check if the existing view is being reused otherwise inflate the view.
        if(convertView == null){
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.news_list_items , parent,false);
        }
        //Get the object located at the position.
        News currentNews = getItem(position);

        //find the text view in the list item.
        TextView webTitleTextView = convertView.findViewById(R.id.web_title);
        //Get the current news title and set in the web title text view.
        webTitleTextView.setText(currentNews.getWebTitle());

        TextView authorNameTextView = convertView.findViewById(R.id.author_name);
        authorNameTextView.setText(currentNews.getAuthorName());

        TextView sectionNameTextView = convertView.findViewById(R.id.section_name);
        sectionNameTextView.setText(currentNews.getSectionName());

        TextView publicationDateTextView = convertView.findViewById(R.id.publication_date);
        publicationDateTextView.setText(currentNews.getPublishedDate());

        return convertView;
    }
}
