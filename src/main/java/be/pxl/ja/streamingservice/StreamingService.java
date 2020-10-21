package be.pxl.ja.streamingservice;

import be.pxl.ja.streamingservice.exception.*;
import be.pxl.ja.streamingservice.model.*;
import be.pxl.ja.streamingservice.repository.*;

import java.time.LocalDate;
import java.util.List;

public class StreamingService {

	private ContentRepository contentRepository = new ContentRepository();
	private AccountRepository accountRepository = new AccountRepository();

	public StreamingService() {
		Account testAccount = new Account("test@pxl.be", "test123");
		testAccount.setStreamingPlan(StreamingPlan.PREMIUM);
		testAccount.getProfiles().get(0).setDateOfBirth(LocalDate.of(2000, 5, 8));
		addAccount(testAccount);
	}

	public void addAccount(Account account) {
		accountRepository.addAccount(account);
	}

	public List<Content> getContentList() {
		return contentRepository.getContentList();
	}

	public Account verifyAndGetAccount(String email, String password) throws AccountNotFoundException, InvalidPasswordException {
		Account account = accountRepository.findAccount(email);
		if (account == null) {
			throw new AccountNotFoundException(email);
		}
		if (!account.verifyPassword(password)) {
			throw new InvalidPasswordException();
		}
		return account;
	}
}
