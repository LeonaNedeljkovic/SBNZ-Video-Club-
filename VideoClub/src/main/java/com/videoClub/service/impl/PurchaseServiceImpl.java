package com.videoClub.service.impl;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.videoClub.exception.EntityNotFound;
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
	
	private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
	private DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

	@Override
	public Purchase save(RegisteredUser user, long offerId) {
		KieSession kieSession = kieContainer.newKieSession("purchaseRulesSession");
		Purchase purchase = new Purchase();
		purchase.setDate(LocalDateTime.parse(sdf.format(new Date()),df));
		purchase.setUser(user);
		Offer offer = offerService.getOne(offerId);
		purchase.setOffer(offer);
		purchase.setPrice(offer.getPrice());
		purchase.setPurchasedMinutes(offer.getMinutes());
		kieSession.insert(purchase);
		kieSession.insert(user);
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
	public List<Purchase> getLastMonthPurchases(Long userId, LocalDateTime now, LocalDateTime monthAgo) {
		return purchaseRepository.getLastMonthPurchases(userId, now, monthAgo);
	}
}
