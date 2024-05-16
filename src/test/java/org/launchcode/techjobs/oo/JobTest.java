package org.launchcode.techjobs.oo;

import org.junit.Assert;
import org.junit.Test;

import static java.lang.Character.getName;
import static java.lang.System.lineSeparator;
import static org.junit.Assert.*;


public class JobTest {
    //TODO: Create your unit tests here
    @Test
    public void testSettingJobId() {
        Job job1 = new Job();
        Job job2 = new Job();
        assertNotEquals(job1.getId(), job2.getId());
    }

    @Test
    public void testJobConstructorSetsAllFields() {
        Job job = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        assertEquals("Product tester", job.getName());
        assertEquals("ACME", job.getEmployer().getValue());
        assertEquals("Desert", job.getLocation().getValue());
        assertEquals("Quality control", job.getPositionType().getValue());
        assertEquals("Persistence", job.getCoreCompetency().getValue());
        Assert.assertTrue(job.getName().equals("Product tester"));
        Assert.assertTrue(job.getEmployer() instanceof Employer);
        Assert.assertTrue(job.getLocation() instanceof Location);
        Assert.assertTrue(job.getPositionType() instanceof PositionType);
        Assert.assertTrue(job.getCoreCompetency() instanceof  CoreCompetency);
    }

    @Test
    public void testJobsForEquality() {
        Job job1 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        Job job2 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        assertNotEquals(job1.getId(), job2.getId());
    }

    @Test
    public void testToStringStartsAndEndsWithNewLine(){
       Job job = new Job("Product tester", new Employer("ACME"),
               new Location("Desert"),
               new PositionType("Quality control"),
               new CoreCompetency("Persistence"));
        assertTrue(job.toString().startsWith(System.lineSeparator()));
        assertTrue(job.toString().endsWith(System.lineSeparator()));
    }

    @Test
    public void testToStringContainsCorrectLabelsAndData(){
      Job  job = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));

      assertEquals(job.toString(),System.lineSeparator() +"ID: " +job.getId()+
              "\nName: " + job.getName() +
              "\nEmployer: " + job.getEmployer().getValue() +
              "\nLocation: " + job.getLocation().getValue() +
              "\nPosition Type: " + job.getPositionType().getValue() +
              "\nCore Competency: " + job.getCoreCompetency().getValue() + System.lineSeparator());
    }



    @Test
    public void testToStringHandlesEmptyField(){
        Job  job = new Job("Product tester", new Employer(""), new Location(""), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        assertEquals(job.toString(),System.lineSeparator() + "ID: "+               job.getId() + "\nName: " + job.getName() + "\nEmployer: " + "Data not available" + "\nLocation: " + "Data not available" + "\nPosition Type: " + job.getPositionType().getValue() + "\nCore Competency: " + job.getCoreCompetency().getValue() + System.lineSeparator());
    }


}