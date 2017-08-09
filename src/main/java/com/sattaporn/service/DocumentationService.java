package com.sattaporn.service;

import com.sattaporn.model.Documentation;

public interface DocumentationService {

	public Documentation createDocument(Documentation documentation);
	
	public Documentation findDocument(Documentation documentation);
	
	public Documentation updateDocument(Documentation documentation);
	
	public void removeDocument(int id) ;
	
}
