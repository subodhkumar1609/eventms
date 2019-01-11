package com.sbd.db.entity;

public class Participants extends CommonBean
{
	private Events event;
	private ParticipantGroups participantGroup;
	private String paidFlag, attendFlag;
	private String name, email;
	
	public Events getEvent()
	{
		return event;
	}
	public void setEvent(Events event)
	{
		this.event = event;
	}
	public ParticipantGroups getParticipantGroup()
	{
		return participantGroup;
	}
	public void setParticipantGroup(ParticipantGroups participantGroup)
	{
		this.participantGroup = participantGroup;
	}
	public String getPaidFlag()
	{
		return paidFlag;
	}
	public void setPaidFlag(String paidFlag)
	{
		this.paidFlag = paidFlag;
	}
	public String getAttendFlag()
	{
		return attendFlag;
	}
	public void setAttendFlag(String attendFlag)
	{
		this.attendFlag = attendFlag;
	}
	public String getName()
	{
		return name;
	}
	public void setName(String name)
	{
		this.name = name;
	}
	public String getEmail()
	{
		return email;
	}
	public void setEmail(String email)
	{
		this.email = email;
	}
	@Override
	public String toString()
	{
		return "Participants [event=" + event + ", participantGroup=" + participantGroup + ", paidFlag=" + paidFlag
				+ ", attendFlag=" + attendFlag + ", name=" + name + ", email=" + email + "]";
	}
}
