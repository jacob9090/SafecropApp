package com.jacob.fruitoftek.safecrop.sustain.inspection;

import android.database.Cursor;
import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

public class InspectionModel implements Parcelable {

    private int id;
    private String district;
    private String community;
    private String farmer_id;
    private String farmer_name;
    private String ghana_card;
    private String farmer_yob;
    private String phone_number;
    private String gender;
    private String inspection_date;
    private String inspector_name;
    private String inspection_question1;
    private String inspection_question2;
    private String inspection_question3;
    private String inspection_question4;
    private String inspection_question5;
    private String inspection_question6;
    private String inspection_question7;
    private String inspection_question8;
    private String inspection_question9;
    private String inspection_question10;
    private String inspection_question11;
    private String inspection_question12;
    private String inspection_question13;
    private String inspection_question14;
    private String inspection_question15;
    private String inspection_question16;
    private String inspection_question17;
    private String inspection_question18;
    private String inspection_question19;
    private String inspection_question20;
    private String inspection_question21;
    private String inspection_question22;
    private String inspection_question23;
    private String inspection_question24;
    private String inspection_question25;
    private String inspection_question26;
    private String inspection_question27;
    private String inspection_question28;
    private String inspection_question29;
    private String inspection_question30;
    private String inspection_question31;
    private String inspection_question32;
    private String inspection_question33;
    private String inspection_question34;
    private String inspection_question35;
    private String inspection_question36;
    private String inspection_question37;
    private String inspection_question38;
    private String inspection_question39;
    private String inspection_question40;
    private String inspection_question41;
    private String inspection_question42;
    private String inspection_question43;
    private String inspection_question44;
    private String inspection_question45;
    private String inspection_question46;
    private String inspection_question47;
    private String inspection_question48;
    private String inspection_question49;
    private String inspection_question50;
    private String inspection_question51;
    private String inspection_question52;
    private String inspection_question53;
    private String inspection_question54;
    private String inspection_question55;
    private String inspection_question56;
    private String inspection_question57;
    private String inspection_question58;
    private String inspection_question59;
    private String inspection_question60;
    private String inspection_question61;
    private String inspection_question62;
    private String inspection_question63;
    private String inspection_location;
    private Uri farmer_photo;
    private String signature;
    private String is_sync;
    private String is_draft;
    private String userFname;
    private String userLname;
    private String userEmail;
    private String onCreate;
    private String onUpdate;

    public InspectionModel(int id, String district, String community, String farmer_id, String farmer_name,
                           String ghana_card, String farmer_yob, String phone_number, String gender,
                           String inspection_date, String inspector_name, String inspection_question1,
                           String inspection_question2, String inspection_question3, String inspection_question4,
                           String inspection_question5, String inspection_question6, String inspection_question7,
                           String inspection_question8, String inspection_question9, String inspection_question10,
                           String inspection_question11, String inspection_question12, String inspection_question13,
                           String inspection_question14, String inspection_question15, String inspection_question16,
                           String inspection_question17, String inspection_question18, String inspection_question19,
                           String inspection_question20, String inspection_question21, String inspection_question22,
                           String inspection_question23, String inspection_question24, String inspection_question25,
                           String inspection_question26, String inspection_question27, String inspection_question28,
                           String inspection_question29, String inspection_question30, String inspection_question31,
                           String inspection_question32, String inspection_question33, String inspection_question34,
                           String inspection_question35, String inspection_question36, String inspection_question37,
                           String inspection_question38, String inspection_question39, String inspection_question40,
                           String inspection_question41, String inspection_question42, String inspection_question43,
                           String inspection_question44, String inspection_question45, String inspection_question46,
                           String inspection_question47, String inspection_question48, String inspection_question49,
                           String inspection_question50, String inspection_question51, String inspection_question52,
                           String inspection_question53, String inspection_question54, String inspection_question55,
                           String inspection_question56, String inspection_question57, String inspection_question58,
                           String inspection_question59, String inspection_question60, String inspection_question61,
                           String inspection_question62, String inspection_question63, String inspection_location,
                           Uri farmer_photo, String signature, String is_sync, String is_draft, String userFname,
                           String userLname, String userEmail, String onCreate, String onUpdate) {
        this.id = id;
        this.district = district;
        this.community = community;
        this.farmer_id = farmer_id;
        this.farmer_name = farmer_name;
        this.ghana_card = ghana_card;
        this.farmer_yob = farmer_yob;
        this.phone_number = phone_number;
        this.gender = gender;
        this.inspection_date = inspection_date;
        this.inspector_name = inspector_name;
        this.inspection_question1 = inspection_question1;
        this.inspection_question2 = inspection_question2;
        this.inspection_question3 = inspection_question3;
        this.inspection_question4 = inspection_question4;
        this.inspection_question5 = inspection_question5;
        this.inspection_question6 = inspection_question6;
        this.inspection_question7 = inspection_question7;
        this.inspection_question8 = inspection_question8;
        this.inspection_question9 = inspection_question9;
        this.inspection_question10 = inspection_question10;
        this.inspection_question11 = inspection_question11;
        this.inspection_question12 = inspection_question12;
        this.inspection_question13 = inspection_question13;
        this.inspection_question14 = inspection_question14;
        this.inspection_question15 = inspection_question15;
        this.inspection_question16 = inspection_question16;
        this.inspection_question17 = inspection_question17;
        this.inspection_question18 = inspection_question18;
        this.inspection_question19 = inspection_question19;
        this.inspection_question20 = inspection_question20;
        this.inspection_question21 = inspection_question21;
        this.inspection_question22 = inspection_question22;
        this.inspection_question23 = inspection_question23;
        this.inspection_question24 = inspection_question24;
        this.inspection_question25 = inspection_question25;
        this.inspection_question26 = inspection_question26;
        this.inspection_question27 = inspection_question27;
        this.inspection_question28 = inspection_question28;
        this.inspection_question29 = inspection_question29;
        this.inspection_question30 = inspection_question30;
        this.inspection_question31 = inspection_question31;
        this.inspection_question32 = inspection_question32;
        this.inspection_question33 = inspection_question33;
        this.inspection_question34 = inspection_question34;
        this.inspection_question35 = inspection_question35;
        this.inspection_question36 = inspection_question36;
        this.inspection_question37 = inspection_question37;
        this.inspection_question38 = inspection_question38;
        this.inspection_question39 = inspection_question39;
        this.inspection_question40 = inspection_question40;
        this.inspection_question41 = inspection_question41;
        this.inspection_question42 = inspection_question42;
        this.inspection_question43 = inspection_question43;
        this.inspection_question44 = inspection_question44;
        this.inspection_question45 = inspection_question45;
        this.inspection_question46 = inspection_question46;
        this.inspection_question47 = inspection_question47;
        this.inspection_question48 = inspection_question48;
        this.inspection_question49 = inspection_question49;
        this.inspection_question50 = inspection_question50;
        this.inspection_question51 = inspection_question51;
        this.inspection_question52 = inspection_question52;
        this.inspection_question53 = inspection_question53;
        this.inspection_question54 = inspection_question54;
        this.inspection_question55 = inspection_question55;
        this.inspection_question56 = inspection_question56;
        this.inspection_question57 = inspection_question57;
        this.inspection_question58 = inspection_question58;
        this.inspection_question59 = inspection_question59;
        this.inspection_question60 = inspection_question60;
        this.inspection_question61 = inspection_question61;
        this.inspection_question62 = inspection_question62;
        this.inspection_question63 = inspection_question63;
        this.inspection_location = inspection_location;
        this.farmer_photo = farmer_photo;
        this.signature = signature;
        this.is_sync = is_sync;
        this.is_draft = is_draft;
        this.userFname = userFname;
        this.userLname = userLname;
        this.userEmail = userEmail;
        this.onCreate = onCreate;
        this.onUpdate = onUpdate;
    }

    protected InspectionModel(Parcel in) {
        id = in.readInt();
        farmer_id = in.readString();
        farmer_name = in.readString();
        district = in.readString();
        community = in.readString();
        ghana_card = in.readString();
        farmer_yob = in.readString();
        phone_number = in.readString();
        gender = in.readString();
        inspection_date = in.readString();
        inspector_name = in.readString();
        inspection_question1 = in.readString();
        inspection_question2 = in.readString();
        inspection_question3 = in.readString();
        inspection_question4 = in.readString();
        inspection_question5 = in.readString();
        inspection_question6 = in.readString();
        inspection_question7 = in.readString();
        inspection_question8 = in.readString();
        inspection_question9 = in.readString();
        inspection_question10 = in.readString();
        inspection_question11 = in.readString();
        inspection_question12 = in.readString();
        inspection_question13 = in.readString();
        inspection_question14 = in.readString();
        inspection_question15 = in.readString();
        inspection_question16 = in.readString();
        inspection_question17 = in.readString();
        inspection_question18 = in.readString();
        inspection_question19 = in.readString();
        inspection_question20 = in.readString();
        inspection_question21 = in.readString();
        inspection_question22 = in.readString();
        inspection_question23 = in.readString();
        inspection_question24 = in.readString();
        inspection_question25 = in.readString();
        inspection_question26 = in.readString();
        inspection_question27 = in.readString();
        inspection_question28 = in.readString();
        inspection_question29 = in.readString();
        inspection_question30 = in.readString();
        inspection_question31 = in.readString();
        inspection_question32 = in.readString();
        inspection_question33 = in.readString();
        inspection_question34 = in.readString();
        inspection_question35 = in.readString();
        inspection_question36 = in.readString();
        inspection_question37 = in.readString();
        inspection_question38 = in.readString();
        inspection_question39 = in.readString();
        inspection_question40 = in.readString();
        inspection_question41 = in.readString();
        inspection_question42 = in.readString();
        inspection_question43 = in.readString();
        inspection_question44 = in.readString();
        inspection_question45 = in.readString();
        inspection_question46 = in.readString();
        inspection_question47 = in.readString();
        inspection_question48 = in.readString();
        inspection_question49 = in.readString();
        inspection_question50 = in.readString();
        inspection_question51 = in.readString();
        inspection_question52 = in.readString();
        inspection_question53 = in.readString();
        inspection_question54 = in.readString();
        inspection_question55 = in.readString();
        inspection_question56 = in.readString();
        inspection_question57 = in.readString();
        inspection_question58 = in.readString();
        inspection_question59 = in.readString();
        inspection_question60 = in.readString();
        inspection_question61 = in.readString();
        inspection_question62 = in.readString();
        inspection_question63 = in.readString();
        inspection_location = in.readString();
        farmer_photo = in.readParcelable(Uri.class.getClassLoader());
        signature = in.readString();
        is_sync = in.readString();
        is_draft = in.readString();
        userFname = in.readString();
        userLname = in.readString();
        userEmail = in.readString();
        onCreate = in.readString();
        onUpdate = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(id);
        dest.writeString(district);
        dest.writeString(community);
        dest.writeString(farmer_id);
        dest.writeString(farmer_name);
        dest.writeString(ghana_card);
        dest.writeString(farmer_yob);
        dest.writeString(phone_number);
        dest.writeString(gender);
        dest.writeString(inspection_date);
        dest.writeString(inspector_name);
        dest.writeString(inspection_question1);
        dest.writeString(inspection_question2);
        dest.writeString(inspection_question3);
        dest.writeString(inspection_question4);
        dest.writeString(inspection_question5);
        dest.writeString(inspection_question6);
        dest.writeString(inspection_question7);
        dest.writeString(inspection_question8);
        dest.writeString(inspection_question9);
        dest.writeString(inspection_question10);
        dest.writeString(inspection_question11);
        dest.writeString(inspection_question12);
        dest.writeString(inspection_question13);
        dest.writeString(inspection_question14);
        dest.writeString(inspection_question15);
        dest.writeString(inspection_question16);
        dest.writeString(inspection_question17);
        dest.writeString(inspection_question18);
        dest.writeString(inspection_question19);
        dest.writeString(inspection_question20);
        dest.writeString(inspection_question21);
        dest.writeString(inspection_question22);
        dest.writeString(inspection_question23);
        dest.writeString(inspection_question24);
        dest.writeString(inspection_question25);
        dest.writeString(inspection_question26);
        dest.writeString(inspection_question27);
        dest.writeString(inspection_question28);
        dest.writeString(inspection_question29);
        dest.writeString(inspection_question30);
        dest.writeString(inspection_question31);
        dest.writeString(inspection_question32);
        dest.writeString(inspection_question33);
        dest.writeString(inspection_question34);
        dest.writeString(inspection_question35);
        dest.writeString(inspection_question36);
        dest.writeString(inspection_question37);
        dest.writeString(inspection_question38);
        dest.writeString(inspection_question39);
        dest.writeString(inspection_question40);
        dest.writeString(inspection_question41);
        dest.writeString(inspection_question42);
        dest.writeString(inspection_question43);
        dest.writeString(inspection_question44);
        dest.writeString(inspection_question45);
        dest.writeString(inspection_question46);
        dest.writeString(inspection_question47);
        dest.writeString(inspection_question48);
        dest.writeString(inspection_question49);
        dest.writeString(inspection_question50);
        dest.writeString(inspection_question51);
        dest.writeString(inspection_question52);
        dest.writeString(inspection_question53);
        dest.writeString(inspection_question54);
        dest.writeString(inspection_question55);
        dest.writeString(inspection_question56);
        dest.writeString(inspection_question57);
        dest.writeString(inspection_question58);
        dest.writeString(inspection_question59);
        dest.writeString(inspection_question60);
        dest.writeString(inspection_question61);
        dest.writeString(inspection_question62);
        dest.writeString(inspection_question63);
        dest.writeString(inspection_location);
        dest.writeParcelable(farmer_photo, flags);
        dest.writeString(signature);
        dest.writeString(is_sync);
        dest.writeString(is_draft);
        dest.writeString(userFname);
        dest.writeString(userLname);
        dest.writeString(userEmail);
        dest.writeString(onCreate);
        dest.writeString(onUpdate);
    }

    public static InspectionModel fromCursor(Cursor cursor) {
        int id = cursor.getInt(cursor.getColumnIndexOrThrow("id"));
        String district = cursor.getString(cursor.getColumnIndexOrThrow("district"));
        String community = cursor.getString(cursor.getColumnIndexOrThrow("community"));
        String farmer_id = cursor.getString(cursor.getColumnIndexOrThrow("farmer_id"));
        String farmer_name = cursor.getString(cursor.getColumnIndexOrThrow("farmer_name"));
        String ghana_card = cursor.getString(cursor.getColumnIndexOrThrow("ghana_card"));
        String farmer_yob = cursor.getString(cursor.getColumnIndexOrThrow("farmer_yob"));
        String phone_number = cursor.getString(cursor.getColumnIndexOrThrow("phone_number"));
        String gender = cursor.getString(cursor.getColumnIndexOrThrow("gender"));
        String inspection_date = cursor.getString(cursor.getColumnIndexOrThrow("inspection_date"));
        String inspector_name = cursor.getString(cursor.getColumnIndexOrThrow("inspector_name"));
        String inspection_question1 = cursor.getString(cursor.getColumnIndexOrThrow("inspection_question1"));
        String inspection_question2 = cursor.getString(cursor.getColumnIndexOrThrow("inspection_question2"));
        String inspection_question3 = cursor.getString(cursor.getColumnIndexOrThrow("inspection_question3"));
        String inspection_question4 = cursor.getString(cursor.getColumnIndexOrThrow("inspection_question4"));
        String inspection_question5 = cursor.getString(cursor.getColumnIndexOrThrow("inspection_question5"));
        String inspection_question6 = cursor.getString(cursor.getColumnIndexOrThrow("inspection_question6"));
        String inspection_question7 = cursor.getString(cursor.getColumnIndexOrThrow("inspection_question7"));
        String inspection_question8 = cursor.getString(cursor.getColumnIndexOrThrow("inspection_question8"));
        String inspection_question9 = cursor.getString(cursor.getColumnIndexOrThrow("inspection_question9"));
        String inspection_question10 = cursor.getString(cursor.getColumnIndexOrThrow("inspection_question10"));
        String inspection_question11 = cursor.getString(cursor.getColumnIndexOrThrow("inspection_question11"));
        String inspection_question12 = cursor.getString(cursor.getColumnIndexOrThrow("inspection_question12"));
        String inspection_question13 = cursor.getString(cursor.getColumnIndexOrThrow("inspection_question13"));
        String inspection_question14 = cursor.getString(cursor.getColumnIndexOrThrow("inspection_question14"));
        String inspection_question15 = cursor.getString(cursor.getColumnIndexOrThrow("inspection_question15"));
        String inspection_question16 = cursor.getString(cursor.getColumnIndexOrThrow("inspection_question16"));
        String inspection_question17 = cursor.getString(cursor.getColumnIndexOrThrow("inspection_question17"));
        String inspection_question18 = cursor.getString(cursor.getColumnIndexOrThrow("inspection_question18"));
        String inspection_question19 = cursor.getString(cursor.getColumnIndexOrThrow("inspection_question19"));
        String inspection_question20 = cursor.getString(cursor.getColumnIndexOrThrow("inspection_question20"));
        String inspection_question21 = cursor.getString(cursor.getColumnIndexOrThrow("inspection_question21"));
        String inspection_question22 = cursor.getString(cursor.getColumnIndexOrThrow("inspection_question22"));
        String inspection_question23 = cursor.getString(cursor.getColumnIndexOrThrow("inspection_question23"));
        String inspection_question24 = cursor.getString(cursor.getColumnIndexOrThrow("inspection_question24"));
        String inspection_question25 = cursor.getString(cursor.getColumnIndexOrThrow("inspection_question25"));
        String inspection_question26 = cursor.getString(cursor.getColumnIndexOrThrow("inspection_question26"));
        String inspection_question27 = cursor.getString(cursor.getColumnIndexOrThrow("inspection_question27"));
        String inspection_question28 = cursor.getString(cursor.getColumnIndexOrThrow("inspection_question28"));
        String inspection_question29 = cursor.getString(cursor.getColumnIndexOrThrow("inspection_question29"));
        String inspection_question30 = cursor.getString(cursor.getColumnIndexOrThrow("inspection_question30"));
        String inspection_question31 = cursor.getString(cursor.getColumnIndexOrThrow("inspection_question31"));
        String inspection_question32 = cursor.getString(cursor.getColumnIndexOrThrow("inspection_question32"));
        String inspection_question33 = cursor.getString(cursor.getColumnIndexOrThrow("inspection_question33"));
        String inspection_question34 = cursor.getString(cursor.getColumnIndexOrThrow("inspection_question34"));
        String inspection_question35 = cursor.getString(cursor.getColumnIndexOrThrow("inspection_question35"));
        String inspection_question36 = cursor.getString(cursor.getColumnIndexOrThrow("inspection_question36"));
        String inspection_question37 = cursor.getString(cursor.getColumnIndexOrThrow("inspection_question37"));
        String inspection_question38 = cursor.getString(cursor.getColumnIndexOrThrow("inspection_question38"));
        String inspection_question39 = cursor.getString(cursor.getColumnIndexOrThrow("inspection_question39"));
        String inspection_question40 = cursor.getString(cursor.getColumnIndexOrThrow("inspection_question40"));
        String inspection_question41 = cursor.getString(cursor.getColumnIndexOrThrow("inspection_question41"));
        String inspection_question42 = cursor.getString(cursor.getColumnIndexOrThrow("inspection_question42"));
        String inspection_question43 = cursor.getString(cursor.getColumnIndexOrThrow("inspection_question43"));
        String inspection_question44 = cursor.getString(cursor.getColumnIndexOrThrow("inspection_question44"));
        String inspection_question45 = cursor.getString(cursor.getColumnIndexOrThrow("inspection_question45"));
        String inspection_question46 = cursor.getString(cursor.getColumnIndexOrThrow("inspection_question46"));
        String inspection_question47 = cursor.getString(cursor.getColumnIndexOrThrow("inspection_question47"));
        String inspection_question48 = cursor.getString(cursor.getColumnIndexOrThrow("inspection_question48"));
        String inspection_question49 = cursor.getString(cursor.getColumnIndexOrThrow("inspection_question49"));
        String inspection_question50 = cursor.getString(cursor.getColumnIndexOrThrow("inspection_question50"));
        String inspection_question51 = cursor.getString(cursor.getColumnIndexOrThrow("inspection_question51"));
        String inspection_question52 = cursor.getString(cursor.getColumnIndexOrThrow("inspection_question52"));
        String inspection_question53 = cursor.getString(cursor.getColumnIndexOrThrow("inspection_question53"));
        String inspection_question54 = cursor.getString(cursor.getColumnIndexOrThrow("inspection_question54"));
        String inspection_question55 = cursor.getString(cursor.getColumnIndexOrThrow("inspection_question55"));
        String inspection_question56 = cursor.getString(cursor.getColumnIndexOrThrow("inspection_question56"));
        String inspection_question57 = cursor.getString(cursor.getColumnIndexOrThrow("inspection_question57"));
        String inspection_question58 = cursor.getString(cursor.getColumnIndexOrThrow("inspection_question58"));
        String inspection_question59 = cursor.getString(cursor.getColumnIndexOrThrow("inspection_question59"));
        String inspection_question60 = cursor.getString(cursor.getColumnIndexOrThrow("inspection_question60"));
        String inspection_question61 = cursor.getString(cursor.getColumnIndexOrThrow("inspection_question61"));
        String inspection_question62 = cursor.getString(cursor.getColumnIndexOrThrow("inspection_question62"));
        String inspection_question63 = cursor.getString(cursor.getColumnIndexOrThrow("inspection_question63"));
        String inspection_location = cursor.getString(cursor.getColumnIndexOrThrow("inspection_location"));
        // Farmer photo as Uri
        String farmer_photo_str = cursor.getString(cursor.getColumnIndexOrThrow("farmer_photo"));
        Uri farmer_photo = (farmer_photo_str != null && !farmer_photo_str.isEmpty()) ? Uri.parse(farmer_photo_str) : null;
        String signature = cursor.getString(cursor.getColumnIndexOrThrow("signature"));
        String is_sync = cursor.getString(cursor.getColumnIndexOrThrow("is_sync"));
        String is_draft = cursor.getString(cursor.getColumnIndexOrThrow("is_draft"));
        String userFname = cursor.getString(cursor.getColumnIndexOrThrow("user_fname"));
        String userLname = cursor.getString(cursor.getColumnIndexOrThrow("user_lname"));
        String userEmail = cursor.getString(cursor.getColumnIndexOrThrow("user_email"));
        String onCreate = cursor.getString(cursor.getColumnIndexOrThrow("on_create"));
        String onUpdate = cursor.getString(cursor.getColumnIndexOrThrow("on_update"));

        return new InspectionModel(
                id,
                district,
                community,
                farmer_id,
                farmer_name,
                ghana_card,
                farmer_yob,
                phone_number,
                gender,
                inspection_date,
                inspector_name,
                inspection_question1,
                inspection_question2,
                inspection_question3,
                inspection_question4,
                inspection_question5,
                inspection_question6,
                inspection_question7,
                inspection_question8,
                inspection_question9,
                inspection_question10,
                inspection_question11,
                inspection_question12,
                inspection_question13,
                inspection_question14,
                inspection_question15,
                inspection_question16,
                inspection_question17,
                inspection_question18,
                inspection_question19,
                inspection_question20,
                inspection_question21,
                inspection_question22,
                inspection_question23,
                inspection_question24,
                inspection_question25,
                inspection_question26,
                inspection_question27,
                inspection_question28,
                inspection_question29,
                inspection_question30,
                inspection_question31,
                inspection_question32,
                inspection_question33,
                inspection_question34,
                inspection_question35,
                inspection_question36,
                inspection_question37,
                inspection_question38,
                inspection_question39,
                inspection_question40,
                inspection_question41,
                inspection_question42,
                inspection_question43,
                inspection_question44,
                inspection_question45,
                inspection_question46,
                inspection_question47,
                inspection_question48,
                inspection_question49,
                inspection_question50,
                inspection_question51,
                inspection_question52,
                inspection_question53,
                inspection_question54,
                inspection_question55,
                inspection_question56,
                inspection_question57,
                inspection_question58,
                inspection_question59,
                inspection_question60,
                inspection_question61,
                inspection_question62,
                inspection_question63,
                inspection_location,
                farmer_photo,
                signature,
                is_sync,
                is_draft,
                userFname,
                userLname,
                userEmail,
                onCreate,
                onUpdate
        );
    }

    @Override
    public int describeContents() {
        return 0; // No special contents in this Parcelable
    }

    public static final Creator<InspectionModel> CREATOR = new Creator<InspectionModel>() {
        @Override
        public InspectionModel createFromParcel(Parcel in) {
            return new InspectionModel(in);
        }

        @Override
        public InspectionModel[] newArray(int size) {
            return new InspectionModel[size];
        }
    };

    @SerializedName("farmer_photo")
    public String getFarmerPhotoString() {
        return farmer_photo != null ? farmer_photo.toString() : "";
    }

    // Getters and setters
    public int getId() {
        return id;
    }

    public String getGhana_card() {
        return ghana_card;
    }

    public String getFarmer_yob() {
        return farmer_yob;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public String getGender() {
        return gender;
    }

    public String getInspection_date() {
        return inspection_date;
    }

    public String getInspector_name() {
        return inspector_name;
    }

    public String getFarmer_id() { return farmer_id; }

    public String getFarmer_name() { return farmer_name; }

    public String getDistrict() { return district; }

    public String getCommunity() { return community; }

    public String getInspection_question1() { return inspection_question1; }

    public String getInspection_question2() { return inspection_question2; }

    public String getInspection_question3() { return inspection_question3;}

    public String getInspection_question4() { return inspection_question4; }

    public String getInspection_question5() { return inspection_question5; }

    public String getInspection_question6() {
        return inspection_question6;
    }

    public String getInspection_question7() {
        return inspection_question7;
    }

    public String getInspection_question8() {
        return inspection_question8;
    }

    public String getInspection_question9() {
        return inspection_question9;
    }

    public String getInspection_question10() {
        return inspection_question10;
    }

    public String getInspection_question11() {
        return inspection_question11;
    }

    public String getInspection_question12() {
        return inspection_question12;
    }

    public String getInspection_question13() {
        return inspection_question13;
    }

    public String getInspection_question14() {
        return inspection_question14;
    }

    public String getInspection_question15() {
        return inspection_question15;
    }

    public String getInspection_question16() {
        return inspection_question16;
    }

    public String getInspection_question17() {
        return inspection_question17;
    }

    public String getInspection_question18() {
        return inspection_question18;
    }

    public String getInspection_question19() {
        return inspection_question19;
    }

    public String getInspection_question20() {
        return inspection_question20;
    }

    public String getInspection_question21() {
        return inspection_question21;
    }

    public String getInspection_question22() {
        return inspection_question22;
    }

    public String getInspection_question23() {
        return inspection_question23;
    }

    public String getInspection_question24() {
        return inspection_question24;
    }

    public String getInspection_question25() {
        return inspection_question25;
    }

    public String getInspection_question26() {
        return inspection_question26;
    }

    public String getInspection_question27() {
        return inspection_question27;
    }

    public String getInspection_question28() {
        return inspection_question28;
    }

    public String getInspection_question29() {
        return inspection_question29;
    }

    public String getInspection_question30() {
        return inspection_question30;
    }

    public String getInspection_question31() {
        return inspection_question31;
    }

    public String getInspection_question32() {
        return inspection_question32;
    }

    public String getInspection_question33() {
        return inspection_question33;
    }

    public String getInspection_question34() {
        return inspection_question34;
    }

    public String getInspection_question35() {
        return inspection_question35;
    }

    public String getInspection_question36() {
        return inspection_question36;
    }

    public String getInspection_question37() {
        return inspection_question37;
    }

    public String getInspection_question38() {
        return inspection_question38;
    }

    public String getInspection_question39() {
        return inspection_question39;
    }

    public String getInspection_question40() {
        return inspection_question40;
    }

    public String getInspection_question41() {
        return inspection_question41;
    }

    public String getInspection_question42() {
        return inspection_question42;
    }

    public String getInspection_question43() {
        return inspection_question43;
    }

    public String getInspection_question44() {
        return inspection_question44;
    }

    public String getInspection_question45() {
        return inspection_question45;
    }

    public String getInspection_question46() {
        return inspection_question46;
    }

    public String getInspection_question47() {
        return inspection_question47;
    }

    public String getInspection_question48() {
        return inspection_question48;
    }

    public String getInspection_question49() {
        return inspection_question49;
    }

    public String getInspection_question50() {
        return inspection_question50;
    }

    public String getInspection_question51() {
        return inspection_question51;
    }

    public String getInspection_question52() {
        return inspection_question52;
    }

    public String getInspection_question53() {
        return inspection_question53;
    }

    public String getInspection_question54() {
        return inspection_question54;
    }

    public String getInspection_question55() {
        return inspection_question55;
    }

    public String getInspection_question56() {
        return inspection_question56;
    }

    public String getInspection_question57() {
        return inspection_question57;
    }

    public String getInspection_question58() {
        return inspection_question58;
    }

    public String getInspection_question59() {
        return inspection_question59;
    }

    public String getInspection_question60() {
        return inspection_question60;
    }

    public String getInspection_question61() {
        return inspection_question61;
    }

    public String getInspection_question62() {
        return inspection_question62;
    }

    public String getInspection_question63() {
        return inspection_question63;
    }

    public String getInspection_location() { return inspection_location; }

    public Uri getFarmer_photo() { return farmer_photo; }

    public String getFarmer_photoString() { return farmer_photo != null ? farmer_photo.toString() : ""; }

    public String getSignature() { return signature; }

    public String getIs_sync() { return is_sync; }

    public String getIs_draft() { return is_draft; }

    public String getUserFname() { return userFname; }

    public String getUserLname() { return userLname; }

    public String getUserEmail() { return userEmail; }

    public String getOnCreate() { return onCreate; }

    public String getOnUpdate() { return onUpdate; }


    public void setInspection_question5(String inspection_question5) { this.inspection_question5 = inspection_question5; }

    public void setId(int id) { this.id = id; }

    public void setGhana_card(String ghana_card) {
        this.ghana_card = ghana_card;
    }

    public void setFarmer_yob(String farmer_yob) {
        this.farmer_yob = farmer_yob;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setInspection_date(String inspection_date) {
        this.inspection_date = inspection_date;
    }

    public void setInspector_name(String inspector_name) {
        this.inspector_name = inspector_name;
    }

    public void setFarmer_id(String farmer_id) { this.farmer_id = farmer_id; }

    public void setFarmer_name(String farmer_name) { this.farmer_name = farmer_name; }

    public void setDistrict(String district) { this.district = district; }

    public void setCommunity(String community) { this.community = community; }

    public void setInspection_question1(String inspection_question1) { this.inspection_question1 = inspection_question1; }

    public void setInspection_question2(String inspection_question2) { this.inspection_question2 = inspection_question2; }

    public void setInspection_question3(String inspection_question3) { this.inspection_question3 = inspection_question3; }

    public void setInspection_question4(String inspection_question4) { this.inspection_question4 = inspection_question4; }

    public void setInspection_question6(String inspection_question6) {
        this.inspection_question6 = inspection_question6;
    }

    public void setInspection_question7(String inspection_question7) {
        this.inspection_question7 = inspection_question7;
    }

    public void setInspection_question8(String inspection_question8) {
        this.inspection_question8 = inspection_question8;
    }

    public void setInspection_question9(String inspection_question9) {
        this.inspection_question9 = inspection_question9;
    }

    public void setInspection_question10(String inspection_question10) {
        this.inspection_question10 = inspection_question10;
    }

    public void setInspection_question11(String inspection_question11) {
        this.inspection_question11 = inspection_question11;
    }

    public void setInspection_question12(String inspection_question12) {
        this.inspection_question12 = inspection_question12;
    }

    public void setInspection_question13(String inspection_question13) {
        this.inspection_question13 = inspection_question13;
    }

    public void setInspection_question14(String inspection_question14) {
        this.inspection_question14 = inspection_question14;
    }

    public void setInspection_question15(String inspection_question15) {
        this.inspection_question15 = inspection_question15;
    }

    public void setInspection_question16(String inspection_question16) {
        this.inspection_question16 = inspection_question16;
    }

    public void setInspection_question17(String inspection_question17) {
        this.inspection_question17 = inspection_question17;
    }

    public void setInspection_question18(String inspection_question18) {
        this.inspection_question18 = inspection_question18;
    }

    public void setInspection_question19(String inspection_question19) {
        this.inspection_question19 = inspection_question19;
    }

    public void setInspection_question20(String inspection_question20) {
        this.inspection_question20 = inspection_question20;
    }

    public void setInspection_question21(String inspection_question21) {
        this.inspection_question21 = inspection_question21;
    }

    public void setInspection_question22(String inspection_question22) {
        this.inspection_question22 = inspection_question22;
    }

    public void setInspection_question23(String inspection_question23) {
        this.inspection_question23 = inspection_question23;
    }

    public void setInspection_question24(String inspection_question24) {
        this.inspection_question24 = inspection_question24;
    }

    public void setInspection_question25(String inspection_question25) {
        this.inspection_question25 = inspection_question25;
    }

    public void setInspection_question26(String inspection_question26) {
        this.inspection_question26 = inspection_question26;
    }

    public void setInspection_question27(String inspection_question27) {
        this.inspection_question27 = inspection_question27;
    }

    public void setInspection_question28(String inspection_question28) {
        this.inspection_question28 = inspection_question28;
    }

    public void setInspection_question29(String inspection_question29) {
        this.inspection_question29 = inspection_question29;
    }

    public void setInspection_question30(String inspection_question30) {
        this.inspection_question30 = inspection_question30;
    }

    public void setInspection_question31(String inspection_question31) {
        this.inspection_question31 = inspection_question31;
    }

    public void setInspection_question32(String inspection_question32) {
        this.inspection_question32 = inspection_question32;
    }

    public void setInspection_question33(String inspection_question33) {
        this.inspection_question33 = inspection_question33;
    }

    public void setInspection_question34(String inspection_question34) {
        this.inspection_question34 = inspection_question34;
    }

    public void setInspection_question35(String inspection_question35) {
        this.inspection_question35 = inspection_question35;
    }

    public void setInspection_question36(String inspection_question36) {
        this.inspection_question36 = inspection_question36;
    }

    public void setInspection_question37(String inspection_question37) {
        this.inspection_question37 = inspection_question37;
    }

    public void setInspection_question38(String inspection_question38) {
        this.inspection_question38 = inspection_question38;
    }

    public void setInspection_question39(String inspection_question39) {
        this.inspection_question39 = inspection_question39;
    }

    public void setInspection_question40(String inspection_question40) {
        this.inspection_question40 = inspection_question40;
    }

    public void setInspection_question41(String inspection_question41) {
        this.inspection_question41 = inspection_question41;
    }

    public void setInspection_question42(String inspection_question42) {
        this.inspection_question42 = inspection_question42;
    }

    public void setInspection_question43(String inspection_question43) {
        this.inspection_question43 = inspection_question43;
    }

    public void setInspection_question44(String inspection_question44) {
        this.inspection_question44 = inspection_question44;
    }

    public void setInspection_question45(String inspection_question45) {
        this.inspection_question45 = inspection_question45;
    }

    public void setInspection_question46(String inspection_question46) {
        this.inspection_question46 = inspection_question46;
    }

    public void setInspection_question47(String inspection_question47) {
        this.inspection_question47 = inspection_question47;
    }

    public void setInspection_question48(String inspection_question48) {
        this.inspection_question48 = inspection_question48;
    }

    public void setInspection_question49(String inspection_question49) {
        this.inspection_question49 = inspection_question49;
    }

    public void setInspection_question50(String inspection_question50) {
        this.inspection_question50 = inspection_question50;
    }

    public void setInspection_question51(String inspection_question51) {
        this.inspection_question51 = inspection_question51;
    }

    public void setInspection_question52(String inspection_question52) {
        this.inspection_question52 = inspection_question52;
    }

    public void setInspection_question53(String inspection_question53) {
        this.inspection_question53 = inspection_question53;
    }

    public void setInspection_question54(String inspection_question54) {
        this.inspection_question54 = inspection_question54;
    }

    public void setInspection_question55(String inspection_question55) {
        this.inspection_question55 = inspection_question55;
    }

    public void setInspection_question56(String inspection_question56) {
        this.inspection_question56 = inspection_question56;
    }

    public void setInspection_question57(String inspection_question57) {
        this.inspection_question57 = inspection_question57;
    }

    public void setInspection_question58(String inspection_question58) {
        this.inspection_question58 = inspection_question58;
    }

    public void setInspection_question59(String inspection_question59) {
        this.inspection_question59 = inspection_question59;
    }

    public void setInspection_question60(String inspection_question60) {
        this.inspection_question60 = inspection_question60;
    }

    public void setInspection_question61(String inspection_question61) {
        this.inspection_question61 = inspection_question61;
    }

    public void setInspection_question62(String inspection_question62) {
        this.inspection_question62 = inspection_question62;
    }

    public void setInspection_question63(String inspection_question63) {
        this.inspection_question63 = inspection_question63;
    }

    public void setInspection_location(String inspection_location) { this.inspection_location = inspection_location; }

    public void setFarmer_photo(String farmer_photo) {
        this.farmer_photo = (farmer_photo != null && !farmer_photo.isEmpty()) ? Uri.parse(farmer_photo) : null;
    }
    public void setFarmer_photo(Uri farmer_photo) { this.farmer_photo = farmer_photo; }

    public void setSignature(String signature) { this.signature = signature; }

    public void setIs_sync(String is_sync) { this.is_sync = is_sync; }

    public void setIs_draft(String is_draft) { this.is_draft = is_draft; }

    public void setUserFname(String userFname) { this.userFname = userFname; }

    public void setUserLname(String userLname) { this.userLname = userLname; }

    public void setUserEmail(String userEmail) { this.userEmail = userEmail; }

    public void setOnCreate(String onCreate) { this.onCreate = onCreate; }

    public void setOnUpdate(String onUpdate) { this.onUpdate = onUpdate; }
}