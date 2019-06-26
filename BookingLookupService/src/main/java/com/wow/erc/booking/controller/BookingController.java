package com.wow.erc.booking.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.wow.erc.booking.entity.BooingSearchParam;
import com.wow.erc.booking.model.ApiResultResponse;
import com.wow.erc.booking.model.Booking;
import com.wow.erc.booking.service.BookingService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;


@CrossOrigin
@RequestMapping("/Booking")
@Api(value = "BookingController", description = "Used to manage Booking Lookup operations")
@RestController
public class BookingController {
	
	@Autowired
	private BookingService bookingService;
	@CrossOrigin
	@RequestMapping( value = "/getBookingInfo", method = RequestMethod.POST)
	@ApiOperation(value = "Booking information will be fetched with this service", response = Iterable.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully retrieved list"),
			@ApiResponse(code = 401, message = "You are not authorized to view the resource"),
			@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
			@ApiResponse(code = 404, message = "The resource you were trying to reach is not found") })
	private Object searchBookings(@RequestBody String jsonString){

		List<Booking> eList=new ArrayList<Booking>();
		ApiResultResponse result = new ApiResultResponse();
		
		try {
			
			ObjectMapper mapper = new ObjectMapper();

			BooingSearchParam searchParam = mapper.readValue(jsonString, BooingSearchParam.class);
			
			String poNo = searchParam.getPoNo();
			String dcNo = searchParam.getDcNo();
			String orderDate = searchParam.getOrderDate();
			String deliveryDate = searchParam.getDeliveryDate();
			String vendorNo = searchParam.getVendorNo();
			
			if( poNo == null && dcNo  == null && orderDate  == null && deliveryDate  == null && vendorNo  == null) {
				result.setMessage("Atleast one parameter( poNo| dcNo| orderDate| deliveryDate| vendorNo) is mandatory");
				return result;
			}
			eList = (ArrayList<Booking>) bookingService.getAllBookings( poNo, dcNo, orderDate, deliveryDate, vendorNo);
			
			if(eList.isEmpty()) {
				result.setMessage("No results found.");
				return result;
			} 
			result.setReturnCode(0);
			result.setResultList(eList);
			return result;
		} catch (Exception e) {
			
			result.setMessage(e.getMessage());
			return result;
			
		}
		
	}
}