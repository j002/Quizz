package com.fastdev.djibril.quizz.data.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class UserMod {


        @SerializedName("user_name")
        @Expose
        private String user_name;
        @SerializedName("user_phonenumber")
        @Expose
        private String user_phonenumber;
        @SerializedName("user_id")
        @Expose
        private Integer user_id;

        public String getUser_name() {
            return user_name;
        }

        public void setUser_name(String user_name) {
            this.user_name = user_name;
        }

        public String getUser_phonenumber() {
            return user_phonenumber;
        }

        public void setUser_phonenumber(String user_phonenumber) {
            this.user_phonenumber = user_phonenumber;
        }

        public Integer getUser_id() {
            return user_id;
        }

        public void setUser_id(Integer user_id) {
            this.user_id = user_id;
        }

        public String getUser_mail() {
            return user_mail;
        }

        public void setUser_mail(String user_mail) {
            this.user_mail = user_mail;
        }

        public String getUser_password() {
            return user_password;
        }

        public void setUser_password(String user_password) {
            this.user_password = user_password;
        }

        public String getUser_adresse() {
            return user_adresse;
        }

        public void setUser_adresse(String user_adresse) {
            this.user_adresse = user_adresse;
        }

        @SerializedName("user_mail")
        @Expose
        private String user_mail;
        @SerializedName("user_password")
        @Expose
        private String user_password;
        @SerializedName("user_adresse")
        @Expose
        private String user_adresse;

        /**
         *
         * @return
         * The title
         */

        @Override
        public String toString() {
            return "User{" +
                    "user_id='" + user_id + '\'' +
                    ",user_name='" + user_name + '\'' +
                    ",user_phonenumber='" + user_phonenumber + '\'' +
                    ",user_mail=" + user_mail +
                    ",user_password=" + user_password +
                    ",user_adresse=" + user_adresse +
                    '}';
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            UserMod user = (UserMod) o;


            if (user_name != null ? !user_name.equals(user.user_name) : user.user_name != null) return false;
            if (user_phonenumber != null ? !user_phonenumber.equals(user.user_phonenumber) : user.user_phonenumber != null) return false;
            if (user_mail != null ? !user_mail.equals(user.user_mail) : user.user_mail != null) return false;
            if (user_password != null ? !user_password.equals(user.user_password) : user.user_password != null) return false;
            if (user_adresse != null ? !user_adresse.equals(user.user_adresse) : user.user_adresse != null) return false;
            return user_id != null ? user_id.equals(user.user_id) : user.user_id == null;

        }

        @Override
        public int hashCode() {
            int result = user_name != null ? user_name.hashCode() : 0;
            result = 31 * result + (user_phonenumber != null ? user_phonenumber.hashCode() : 0);
            result = 31 * result + (user_mail != null ? user_mail.hashCode() : 0);
            result = 31 * result + (user_password != null ? user_password.hashCode() : 0);
            result = 31 * result + (user_adresse != null ? user_adresse.hashCode() : 0);
            result = 31 * result + (user_id != null ? user_id.hashCode() : 0);
            return result;
        }
    }


