package com.innobraves.kairosjava.models.results.subsets;

import javax.json.JsonObject;

/**
 * @author Hex-3-En
 * @version 0.0.1
 */
public class Transaction {
    private boolean success;
    private int topLeftX;
    private int topLeftY;
    private String galleryName;
    private long timestamp;
    private int height;
    private int width;
    private double quality;
    private double confidence;
    private String subjectId;
    private int eyeDistance;
    private int faceId;

    /**
     * Empty private constructor, so it can't be called from outside the class.
     */
    private Transaction(){}

//--------------------------------------------------------------------------------------------------------
//---------------------------Getters and Setters for all fields in this class-----------------------------
//--------------------------------------------------------------------------------------------------------
    public boolean isSuccess() {
        return success;
    }

    public int getTopLeftX() {
        return topLeftX;
    }

    public int getTopLeftY() {
        return topLeftY;
    }

    public String getGalleryName() {
        return galleryName;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }

    public double getQuality() {
        return quality;
    }

    public double getConfidence() {
        return confidence;
    }

    public String getSubjectId() {
        return subjectId;
    }

    public int getEyeDistance() {
        return eyeDistance;
    }

    public int getFaceId() {
        return faceId;
    }
//--------------------------------------------------------------------------------------------------------
//--------------------------------------End of Getters and Setters----------------------------------------
//--------------------------------------------------------------------------------------------------------

    /**
     * Creator method, taking raw JSON data and filling fields with it
     * @param raw raw JSON data with result data
     * @return instance of this class filled with data
     */
    public static Transaction create(JsonObject raw){
        Transaction trans = new Transaction();
        trans.success = raw.getJsonString("status").getString().equals("success");
        trans.topLeftX = raw.getJsonNumber("topLeftX").intValue();
        trans.topLeftY = raw.getJsonNumber("topLeftY").intValue();
        trans.galleryName = raw.getJsonString("gallery_name").getString();
        if(raw.containsKey("timestamp")){
            trans.timestamp = Long.parseLong(raw.getJsonString("timestamp").getString());
        }else{
            trans.timestamp = -1;//-1 to indicate not existing
        }
        trans.height = raw.getJsonNumber("height").intValue();
        trans.width = raw.getJsonNumber("width").intValue();
        trans.quality = raw.getJsonNumber("quality").doubleValue();
        if(raw.containsKey("confidence")){
            trans.confidence = raw.getJsonNumber("confidence").doubleValue();
        }else{
            trans.confidence = 1;
        }
        if(raw.containsKey("subject_id")){
            trans.subjectId = raw.getJsonString("subject_id").getString();
        }else{
            trans.subjectId = "";
        }
        trans.eyeDistance = raw.getJsonNumber("eyeDistance").intValue();
        if(raw.containsKey("face_id")){
            trans.faceId = raw.getJsonNumber("face_id").intValue();
        }else{
            trans.faceId = -1;//-1 to indicate not existing
        }
        return trans;
    }

    @Override
    public String toString() {
        return "Transaction{\n" +
                "success:\t" + success + "\n" +
                "topLeftX:\t" + topLeftX + "\n" +
                "topLeftY:\t" + topLeftY + "\n" +
                "galleryName:\t'" + galleryName + '\'' + "\n" +
                "timestamp:\t" + timestamp + "\n" +
                "height:\t" + height + "\n" +
                "width:\t" + width + "\n" +
                "quality:\t" + quality + "\n" +
                "confidence:\t" + confidence + "\n" +
                "subjectId:\t'" + subjectId + '\'' + "\n" +
                "eyeDistance:\t" + eyeDistance + "\n" +
                "faceId:\t" + faceId + "\n" +
                '}';
    }
}
