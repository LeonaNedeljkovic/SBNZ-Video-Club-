package com.videoClub.service.impl;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Optional;

import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.videoClub.exception.EntityNotFound;
import com.videoClub.model.Action;
import com.videoClub.model.Offer;
import com.videoClub.model.Purchase;
import com.videoClub.model.RegisteredUser;
import com.videoClub.repository.PurchaseRepository;
import com.videoClub.service.OfferService;
import com.videoClub.service.PurchaseService;
import com.videoClub.service.UserService;

@Service
public class PurchaseServiceImpl implements PurchaseService{
	
	@Autowired
	private PurchaseRepository purchaseRepository;
	
	@Autowired
	private OfferService offerService;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private KieContainer kieContainer;
	
	private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	private DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-MM-dd");

	@Override
	public Purchase save(RegisteredUser user, long offerId) {
		KieSession kieSession = kieContainer.newKieSession("purchaseRulesSession");
		Purchase purchase = new Purchase();
		purchase.setDate(LocalDate.parse(sdf.format(new Date()),df));
		purchase.setUser(user);
		Offer offer = offerService.getOne(offerId);
		purchase.setOffer(offer);
		purchase.setPrice(offer.getPrice());
		purchase.setPurchasedMinutes(offer.getMinutes());
		kieSession.insert(purchase);
		kieSession.insert(user);
		for(Action a : user.getAction()){
			kieSession.insert(a);
			System.out.println("aaa");
		}
		System.out.println("bbb");
		kieSession.fireAllRules();
		kieSession.dispose();
		userService.save(user);
		return purchaseRepository.save(purchase);
	}

	@Override
	public Purchase getOne(Long id) {
		Optional<Purchase> purchase = purchaseRepository.findById(id);
		if(purchase.isPresent()){
			return purchase.get();
		}
		else{
			throw new EntityNotFound(id);
		}
	}

	@Override
	public double getLastMonthPayment(RegisteredUser user) {
		// TODO Auto-generated method stub
		return 0;
	}
}
