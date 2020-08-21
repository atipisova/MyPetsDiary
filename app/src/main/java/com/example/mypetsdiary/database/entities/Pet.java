package com.example.mypetsdiary.database.entities;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;
import androidx.room.TypeConverters;

import java.util.Date;

@Entity(tableName = "pet")
@TypeConverters(com.example.pillsInventory.utility.Converters.class)
public class Pet {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "petID")
    public long petID;

    @ColumnInfo(name = "petName")
    @NonNull
    public String petName;

    @ColumnInfo(name = "petType", defaultValue = "dog")
    @NonNull
    public String petType;

    @ColumnInfo(name = "petGender", defaultValue = "male")
    @NonNull
    public String petGender;

    @ColumnInfo(name = "petBreed")
    public String petBreed;

    @ColumnInfo(name = "petFurColor")
    public String petFurColor;

    @ColumnInfo(name = "petFurType")
    public String petFurType;

    @ColumnInfo(name = "petDateType", defaultValue = "exact")
    public String petDateType;

    @ColumnInfo(name = "petDateOfBirth")
    public Date petDateOfBirth;

    @ColumnInfo(name = "petDateOfBirthAround")
    public String petDateOfBirthAround;

    @ColumnInfo(name = "petCastration", defaultValue = "no")
    public String petCastration;

    @ColumnInfo(name = "petFullName")
    public String petFullName = "";

    @ColumnInfo(name = "petMicrochipOrTattoo", defaultValue = "chip")
    public String petMicrochipOrTattoo;

    @ColumnInfo(name = "petChipNumber")
    public String petChipNumber;

    @ColumnInfo(name = "petChipDate")
    public String petChipDate;

    @ColumnInfo(name = "petChipCountry")
    public String petChipCountry;

    @ColumnInfo(name = "petChipPlacement")
    public String petChipPlacement;

    @ColumnInfo(name = "petRegistrationNumber")
    public String petRegistrationNumber;

    @ColumnInfo(name = "petRegistrationCountry")
    public String petRegistrationCountry;

    @ColumnInfo(name = "petClubSite")
    public String petClubSite;

    @ColumnInfo(name = "petOwnerName")
    public String petOwnerName;

    @ColumnInfo(name = "petOwnerPhone")
    public String petOwnerPhone;

    @ColumnInfo(name = "petOwnerEmail")
    public String petOwnerEmail;

    @ColumnInfo(name = "petKernelSite")
    public String petKernelSite;

    @ColumnInfo(name = "petInsuranceCompany")
    public String petInsuranceCompany;

    @ColumnInfo(name = "petInsuranceNumber")
    public String petInsuranceNumber;

    @ColumnInfo(name = "petInsurancePhone")
    public String petInsurancePhone;

    public Pet() {
        petName = "";
        petType = "dog";
        petGender = "male";
        petDateType = "exact";
        petCastration = "no";
        petMicrochipOrTattoo = "chip";
    }
}
