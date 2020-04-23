package com.giantcell.services
import com.digi.gadisolutions.models.Brand
import com.digi.gadisolutions.models.News
import com.google.gson.JsonArray
import com.google.gson.JsonObject
import retrofit2.Call
import retrofit2.http.*
import okhttp3.MultipartBody
import okhttp3.RequestBody
import okhttp3.ResponseBody
import retrofit2.http.POST
import retrofit2.http.Multipart



interface AuthenticationService {

//    @POST("user/editProfile")
//    @FormUrlEncoded
//    abstract fun editProfileRequest(@FieldMap params: Map<String, String>): Call<Authentication>
//
//
//    @POST("user/login")
//    @FormUrlEncoded
//    abstract fun getLoginRequest(@FieldMap params: Map<String, String>): Call<Authentication>
//
//    @POST("user/socialLogin")
//    @FormUrlEncoded
//    abstract fun getSocialLoginRequest(@FieldMap params: Map<String, String>): Call<Authentication>
//
//
//    @POST("user/register")
//    @FormUrlEncoded
//    abstract fun register(@FieldMap params: Map<String, String>): Call<Register>
//
//
//    @POST("user/verifyOTP")
//    @FormUrlEncoded
//    abstract fun verifyOtp(@FieldMap params: Map<String, String>): Call<Register>
//
//    @POST("user/recoverPassword")
//    @FormUrlEncoded
//    abstract fun forgotPassword(@FieldMap params: Map<String, String>): Call<Register>
//
//
    @GET("brand")
    abstract fun getBrand(): Call<ArrayList<Brand>>

    @GET("news")
    abstract fun getNews(): Call<ArrayList<News>>
//
//
//    @POST("doctor/getAddress")
//    @FormUrlEncoded
//    abstract fun getAddressList(@FieldMap params: Map<String, String>): Call<AddressRequest>
//
//
//    @POST("doctor/addAddress")
//    @FormUrlEncoded
//    abstract fun addNewAddress(@FieldMap params: Map<String, String>): Call<AddNewAddressRequest>
//
//    @POST("doctor/getServicecity")
//    @FormUrlEncoded
//    abstract fun getCity(@FieldMap params: Map<String, String>): Call<AddCity>
//
//    @POST("doctor/getCertificate")
//    @FormUrlEncoded
//    abstract fun getCertificate(@FieldMap params: Map<String, String>): Call<Certificate>
//
//    @POST("doctor/addServicecity")
//    @FormUrlEncoded
//    abstract fun addServicecity(@FieldMap params: Map<String, String>): Call<AddNewCity>
//
//    @POST("doctor/deleteServicecity")
//    @FormUrlEncoded
//    abstract fun deleteServicecity(@FieldMap params: Map<String, String>): Call<JsonObject>
//
//    @POST("doctor/deleteCertificate")
//    @FormUrlEncoded
//    abstract fun deleteCertificate(@FieldMap params: Map<String, String>): Call<JsonObject>
//
//    @POST("doctor/editAddress")
//    @FormUrlEncoded
//    abstract fun editAddress(@FieldMap params: Map<String, String>): Call<AddNewAddressRequest>
//
//    @POST("user/doctorlist")
//    @FormUrlEncoded
//    abstract fun getDoctorList(@FieldMap params: Map<String, String>): Call<DoctorRequest>
//
//
//    @POST("doctor/workschedule")
//    @FormUrlEncoded
//    abstract fun getTimeSlotList(@FieldMap params: Map<String, String>): Call<TimeSlotRequest>
//
//    @POST("doctor/schedule")
//    @FormUrlEncoded
//    abstract fun getScheduleList(@FieldMap params: Map<String, String>): Call<TimeSlotRequest>
//
//    @POST("doctor/addWorkSchedule")
//    @FormUrlEncoded
//    abstract fun saveScheduleList(@FieldMap params: Map<String, String>): Call<TimeSlotRequest>
//
//
//    @POST("doctor/addAppointmentBooking")
//    @FormUrlEncoded
//    abstract fun bookTimeSlotList(@FieldMap params: Map<String, String>): Call<BookingRequest>
//
//
//
//    @POST("doctor/getDoctorsAppointmentList")
//    @FormUrlEncoded
//    abstract fun getDoctorsAppointmentList(@FieldMap params: Map<String, String>): Call<DoctorTimeSlotRequest>
//
//
//    @POST("doctor/getUpcomingAppointments")
//    @FormUrlEncoded
//    abstract fun upcomingAppointmentList(@FieldMap params: Map<String, String>): Call<Bookings>
//
//
//    @POST("doctor/getAppointmentDetail")
//    @FormUrlEncoded
//    abstract fun getAppointmentDetail(@FieldMap params: Map<String, String>): Call<BookingSummaryRequest>
//
//
//    @POST("doctor/addAppointmentFeedback")
//    @FormUrlEncoded
//    abstract fun addFeedback(@FieldMap params: Map<String, String>): Call<BookingSummaryRequest>
//
//
//    @POST("doctor/cancelAppointment")
//    @FormUrlEncoded
//    abstract fun cancelAppointment(@FieldMap params: Map<String, String>): Call<BookingSummaryRequest>
//
//
//    @POST("user/doctorDetails")
//    @FormUrlEncoded
//    abstract fun getDoctorprofile(@FieldMap params: Map<String, String>): Call<ProfileRequest>
//
//
//
//    @POST("doctor/getBookings")
//    @FormUrlEncoded
//    abstract fun getAllAppointments(@FieldMap params: Map<String, String>): Call<Bookings>
//
//
//    @POST("equipment/equipmentlist")
//    @FormUrlEncoded
//    abstract fun getAllEquipments(@FieldMap params: Map<String, String>): Call<EquipmentlistRequest>
//
//    @POST("equipment/addequipmentbooking")
//    @FormUrlEncoded
//    abstract fun addEquipments(@FieldMap params: Map<String, String>): Call<BookingRequest>
//
//
//    @POST("ambulance/addambulancebooking")
//    @FormUrlEncoded
//    abstract fun addAmbulance(@FieldMap params: Map<String, String>): Call<BookingRequest>
//
//    @POST("ambulance/ambulancelist")
//    @FormUrlEncoded
//    abstract fun ambulancelist(@FieldMap params: Map<String, String>): Call<AmbulanceRequest>
//
//    @POST("payment/pay")
//    @FormUrlEncoded
//    abstract fun sendPayment(@FieldMap params: Map<String, String>): Call<PaymentRequest>
//
//    @POST("equipment/bookingDetail")
//    @FormUrlEncoded
//    abstract fun getEquipmentDetail(@FieldMap params: Map<String, String>): Call<EquipmentDetailRequest>
//
//    @POST("ambulance/bookingDetail")
//    @FormUrlEncoded
//    abstract fun getAmbulanceDetail(@FieldMap params: Map<String, String>): Call<AmbulanceDetailRequest>
//
//    @POST("api/geocode/json?")
//    abstract fun getAddressLatLong(@Query("address") address: String, @Query("key") key: String): Call<LocationRequest>
//
//    @Multipart
//    @POST("doctor/addDoctorCertificate")
//    fun upload(
//        @Part("doctor_id") description: RequestBody,
//        @Part("image") file: MultipartBody.Part
//    ): Call<ResponseBody>
//
//    @Multipart
//    @POST("doctor/addDoctorCertificate")
//    fun postFile(@Part file: MultipartBody.Part, @Part("doctor_id") doctorId: RequestBody, @Part("degree") degree: RequestBody): Call<ResponseBody>
}