package com.wallethub;

import com.wallethub.model.LogParams;
import com.wallethub.service.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.List;

//TK
//Develop branch come

@SpringBootApplication
public class WebparserApplication implements ApplicationRunner {

	@Autowired
	private LogService service;


	public static void main(String[] args) {
		SpringApplication.run(WebparserApplication.class, args);


	}

	public void run(ApplicationArguments arg0) throws Exception
	{

		HashMap<Object, Object> searchCriteria = new HashMap<Object, Object>();

		ParseSearch.parse(arg0, searchCriteria);
		// System.out.println("Search Criteria " + searchCriteria);


		System.out.println("LogService is started");

		try {

			System.out.println("LogService: All logs loaded");

			//save all log params to db
			service.saveAllLogParams(
					(service.readFromLogFile(searchCriteria.get("accesslog").toString())));
			//		(service.readFromLogFile("tugce.log")));

		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("Could not open the log file,please check");
			e.printStackTrace();
		}

		System.out.println("LogService: All logs saved to database");


		List<LogParams> analyzedLogParams;
		analyzedLogParams = (List<LogParams>) service.analyzeLogParams
				(searchCriteria.get("startDate").toString()
						, searchCriteria.get("endDate").toString()
						, searchCriteria.get("threshold").toString());

		System.out.println("LogService: All logs analyzed");

		service.saveAllLogComments(analyzedLogParams, searchCriteria);

		System.out.println("LogService: All comments saved to database");

		System.out.println("Done");
	}

	static class ParseSearch {
		public static void parse(ApplicationArguments args, HashMap<Object, Object> searchCriteria) {

			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd.HH:mm:ss");

			if (args.containsOption("startDate")) {
				String date = args.getOptionValues("startDate").get(0);

				searchCriteria.put("startDate", LocalDateTime.parse(date, formatter));

			}

			if (args.containsOption("threshold")) {
				searchCriteria.put("threshold", new Long(args.getOptionValues("threshold").get(0)));

			}

			if (args.containsOption("accesslog")) {
				searchCriteria.put("accesslog", new String(args.getOptionValues("accesslog").get(0)));

			}
			if (args.containsOption("duration")) {
				String duration = args.getOptionValues("duration").get(0);

				if (duration.equals("hourly")) {
					searchCriteria.put("endDate", ((LocalDateTime) searchCriteria.get("startDate")).plusHours(1));

				} else if (duration.equals("daily")) {
					searchCriteria.put("endDate", ((LocalDateTime) searchCriteria.get("startDate")).plusDays(1));

				}

			}

		}

	}

}
