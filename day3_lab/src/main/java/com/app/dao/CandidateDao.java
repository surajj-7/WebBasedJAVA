package com.app.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.app.entities.Candidate;

public interface CandidateDao {
//add a method to list all candidates
	List<Candidate> getAllCandidates() throws SQLException;

	// add a method to increment votes
	String incrementCandidateVotes(int candidateId) throws SQLException;
	
	// add a method to show top two candidates
	List<Candidate> topTwoCandidates() throws SQLException;
	
	// add a method to show vote analysis political partywise
	Map<String,Integer> voteAnalysis() throws SQLException;
}
