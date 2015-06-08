package org.vm.account.model;

import java.util.ArrayList;
import org.vm.entity.img.model.Image;
import org.vm.entity.video.model.Video;

public class Account {
	private int accountId;
	private ArrayList<Video> videos;
	private ArrayList<Image> images;

	public Account(int accountId, ArrayList<Video> videos,
			ArrayList<Image> images) {
		super();
		this.accountId = accountId;
		this.videos = videos;
		this.images = images;
	}
	public Account() {
		super();
	}

	public int getAccountId() {
		return accountId;
	}

	public void setAccountId(int accountId) {
		this.accountId = accountId;
	}

	public ArrayList<Video> getVideos() {
		return videos;
	}

	public void setVideos(ArrayList<Video> videos) {
		this.videos = videos;
	}

	public ArrayList<Image> getImages() {
		return images;
	}

	public void setImages(ArrayList<Image> images) {
		this.images = images;
	}

}
