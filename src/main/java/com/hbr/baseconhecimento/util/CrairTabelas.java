package com.hbr.baseconhecimento.util;

import javax.persistence.Persistence;

public class CrairTabelas {
	public static void main(String[] args) {
		Persistence.createEntityManagerFactory("BaseConhecimento");
	}
}
