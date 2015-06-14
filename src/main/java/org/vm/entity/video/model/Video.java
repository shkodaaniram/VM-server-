package org.vm.entity.video.model;

import java.sql.Date;
import java.util.Arrays;

import org.vm.entity.model.Entity;
import org.vm.entity.model.EntityType;
import org.vm.entity.model.FilterType;



public class Video extends Entity {
	private long videoDuration;
	private byte[] videoThumb;
	
	public Video() {
		super();
	}

	public Video(int id, String name, FilterType filterType, String path,
			EntityType entityType, Date uploadedOn, int accountId, long videoDuration,
			byte[] videoThumb) { 
		super(id, name, filterType.getTypeId(), path, entityType, uploadedOn, accountId);
		this.videoDuration = videoDuration;
		this.videoThumb = videoThumb;
	}

	@Override
	public String toString() {
		return "Video [videoDuration=" + videoDuration + ", videoThumb="
				+ Arrays.toString(videoThumb) + ", getId()=" + getId()
				+ ", getName()=" + getName() + ", getFilterType()="
				+ getFilterType() + ", getPath()=" + getPath()
				+ ", getEntityType()=" + getEntityType() + ", getUploadedOn()="
				+ getUploadedOn() + ", getAccountId()=" + getAccountId()
				+ ", getClass()=" + getClass() + "]";
	}

	public long getVideoDuration() {
		return videoDuration;
	}

	public void setVideoDuration(long videoDuration) {
		this.videoDuration = videoDuration;
	}

	public byte[] getVideoThumb() {
		return videoThumb;
	}

	public void setVideoThumb(byte[] videoThumb) {
		this.videoThumb = videoThumb;
	}

}
