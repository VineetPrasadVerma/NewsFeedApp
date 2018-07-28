package com.example.vineetprasadverma.newsfeedapp;

public class News {
    private String mWebTitle;
    private String mAuthorName;
    private String mPublishedDate;
    private String mSectionName;
    private String mUrl;
    private String mImageUrl;

    /**
     * Create a news object.
     *
     * @param webTitle      is the headline of the news.
     * @param authorName    is the author of the news.
     * @param publishedDate is the date on which news is published.
     * @param sectionName   is the section in which news is published.
     * @param url           is the url to the news.
     * @param imageUrl      is the url to the image.
     */

    public News(String webTitle, String authorName, String sectionName, String publishedDate, String url, String imageUrl) {
        mWebTitle = webTitle;
        mAuthorName = authorName;
        mPublishedDate = publishedDate;
        mSectionName = sectionName;
        mUrl = url;
        mImageUrl = imageUrl;
    }

    //return the web title of the news.
    public String getWebTitle() {
        return mWebTitle;
    }

    //return the author name of the news.
    public String getAuthorName() {
        return mAuthorName;
    }

    //return the published date of the news.
    public String getPublishedDate() {
        return mPublishedDate;
    }

    //return the section name in which news is published.
    public String getSectionName() {
        return mSectionName;
    }

    //return the url to the news.
    public String getUrl() {
        return mUrl;
    }

    //return the imageUrl of the news.

    public String getImageUrl() {
        return mImageUrl;
    }
}
