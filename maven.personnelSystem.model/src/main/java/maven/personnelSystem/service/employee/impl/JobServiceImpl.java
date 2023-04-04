package maven.personnelSystem.service.employee.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import maven.personnelSystem.dao.employee.JobRepository;
import maven.personnelSystem.model.employee.Job;
import maven.personnelSystem.service.employee.JobService;

@Service
public class JobServiceImpl implements JobService {

	@Autowired
	private JobRepository jobRepository;

	@Override
	public boolean saveJob(Job job) {
		return jobRepository.saveJob(job);
	}

	@Override
	public boolean deleteJob(Job job) {
		return jobRepository.deleteJob(job);
	}

	@Override
	public Job updateJob(Job job) {
		return jobRepository.updateJob(job);
	}

	@Override
	public Job findJobById(Long jobId) {
		return jobRepository.findJobById(jobId);
	}

	@Override
	public List<Job> findAllJobs() {
		return jobRepository.findAllJobs();
	}

}
