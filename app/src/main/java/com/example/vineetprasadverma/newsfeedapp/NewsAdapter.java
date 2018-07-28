package com.example.vineetprasadverma.newsfeedapp;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.Target;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class NewsAdapter extends ArrayAdapter<News> {

    /**
     * @param context  is the current context i.e. the activity in which adapter is beimg created.
     * @param newsList is the news which is to be displayed.
     */
    public NewsAdapter(Context context, List<News> newsList) {
        super(context, 0, newsList);
    }

    /**
     * @param unformattedDate is the unformatted date.
     * @return formated date will be return.
     */
    private String formatDate(String unformattedDate) {
        SimpleDateFormat inputFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");
        SimpleDateFormat outputFormat = new SimpleDateFormat(" dd/MM h:mm a");
        String formattedDate = null;
        try {
            formattedDate = outputFormat.format(inputFormat.parse(unformattedDate));
        } catch (ParseException e) {
            System.out.println("Input date is not in format yyyy-MM-dd'T'HH:mm:ss'Z'");
        }
        return formattedDate;
    }

  /**  //find the text view in the list item.
    @BindView(R.id.web_title)
    TextView webTitleTextView;

    @BindView(R.id.author_name)
    TextView authorNameTextView;

    @BindView(R.id.section_name)
    TextView sectionNameTextView;

    @BindView(R.id.publication_date)
    TextView publicationDateTextView;

    @BindView(R.id.layout_bg_image)
    RelativeLayout relativeLayout;

   **/

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        //Check if the existing view is being reused otherwise inflate the view.
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.news_list_items, parent, false);
        }
        //ButterKnife.bind(this, convertView);

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
        String formattedDate = formatDate(currentNews.getPublishedDate());
        publicationDateTextView.setText(formattedDate);

        final RelativeLayout relativeLayout = convertView.findViewById(R.id.layout_bg_image);
        //sets the background image to the layout.
        final ImageView img = new ImageView(getContext());
        Picasso.with(getContext()).load(currentNews.getImageUrl()).into(img, new Callback() {
            @Override
            public void onSuccess() {
                relativeLayout.setBackground(img.getDrawable());
            }

            @Override
            public void onError() {
                relativeLayout.setBackgroundResource(R.drawable.news_icon);
            }
        });

        return convertView;
    }
}
