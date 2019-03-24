package com.appmp3.appnhac.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Quangcao {
        @SerializedName("IdQuangCao")
        @Expose
        private String idQuangCao;
        @SerializedName("HinhAnh")
        @Expose
        private String hinhAnh;
        @SerializedName("NoiDung")
        @Expose
        private String noiDung;
        @SerializedName("BaiHat")
        @Expose
        private String baiHat;
        @SerializedName("TenBaiHat")
        @Expose
        private String tenBaiHat;
        @SerializedName("HinhBaiHat")
        @Expose
        private String hinhBaiHat;

        public String getIdQuangCao() {
            return idQuangCao;
        }

        public void setIdQuangCao(String idQuangCao) {
            this.idQuangCao = idQuangCao;
        }

        public String getHinhAnh() {
            return hinhAnh;
        }

        public void setHinhAnh(String hinhAnh) {
            this.hinhAnh = hinhAnh;
        }

        public String getNoiDung() {
            return noiDung;
        }

        public void setNoiDung(String noiDung) {
            this.noiDung = noiDung;
        }

        public String getBaiHat() {
            return baiHat;
        }

        public void setBaiHat(String baiHat) {
            this.baiHat = baiHat;
        }

        public String getTenBaiHat() {
            return tenBaiHat;
        }

        public void setTenBaiHat(String tenBaiHat) {
            this.tenBaiHat = tenBaiHat;
        }

        public String getHinhBaiHat() {
            return hinhBaiHat;
        }

        public void setHinhBaiHat(String hinhBaiHat) {
            this.hinhBaiHat = hinhBaiHat;
        }

    }
