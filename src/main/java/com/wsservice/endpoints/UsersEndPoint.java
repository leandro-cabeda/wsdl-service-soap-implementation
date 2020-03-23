package com.wsservice.endpoints;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import com.wsservice.entities.Userrs;
import com.wsservice.repositories.h2jpa.UsersRepository;
import com.wsservice.users.DeleteUsersRequest;
import com.wsservice.users.DeleteUsersResponse;
import com.wsservice.users.GetAllUsersRequest;
import com.wsservice.users.GetAllUsersResponse;
import com.wsservice.users.GetUsersRequest;
import com.wsservice.users.GetUsersResponse;
import com.wsservice.users.SaveOrUpdateUsersRequest;
import com.wsservice.users.SaveOrUpdateUsersResponse;
import com.wsservice.users.Status;
import com.wsservice.users.Users;


/*
 * EndPoint é o que recebe a requisição, processa e depois envia a resposta
 * */
@Endpoint
public class UsersEndPoint {

	
	private static final String NAMESPACE_URI = "http://wsservice.com/users";
	
	/*@Autowired
	private UsersRepository usersRepository;*/
	
	@Autowired
	private UsersRepository  usersRepository;

	/*@Autowired
	public UsersEndPoint(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }*/
	
	/*
	 * @RequestPayload faz o bind do xml para java ou seja converte a requisição
	 * 
	 * @ResponsePayload faz o bind de java para xml , covnerte para devolver de
	 * volta.
	 * 
	 * @PayloadRoot é como fosse o caminho da url do serviço
	 */
	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "GetUsersRequest")
	@ResponsePayload
	public GetUsersResponse getUsersRequest(@RequestPayload GetUsersRequest request) throws Exception {
		
		GetUsersResponse response = new GetUsersResponse();
		//Users user= usersRepository.findById(request.getId());
		
		Users user= new Users();
		Userrs userr =  usersRepository.findById(request.getId());
		
		if (userr==null)
		{
			throw new Exception("Inválido usuário com Id: "+request.getId());
		}


		/*if(user==null)
		{
			throw new Exception("Inválido usuário com Id: "+request.getId());
		}*/
		
		
		user.setId(userr.getId());
		user.setName(userr.getName());
		user.setEmail(userr.getEmail());
		user.setPhone(userr.getPhone());
		
		response.setUser(user);

		return response;
	}
	
	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "GetAllUsersRequest")
	@ResponsePayload
	public GetAllUsersResponse getAllUsersRequest(@RequestPayload GetAllUsersRequest request) throws Exception  
	{
		GetAllUsersResponse response = new GetAllUsersResponse();
		
		//usersRepository.findAll().stream().forEach(user-> response.getUser().add(user));
		
		if(usersRepository.count()==0)
		{
			throw new Exception("Não existe registros! ");
		}
		
		
		usersRepository.findAll().
		forEach(userr -> {
			
			Users user= new Users();
			user.setId(userr.getId());
			user.setName(userr.getName());
			user.setEmail(userr.getEmail());
			user.setPhone(userr.getPhone());
			
			response.getUser().add(user);
			
		});

		return response;
	}
	
	
	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "DeleteUsersRequest")
	@ResponsePayload
	public DeleteUsersResponse deleteUsersRequest(@RequestPayload DeleteUsersRequest request) throws Exception  
	{
		DeleteUsersResponse response = new DeleteUsersResponse();
		
		//response.setStatus(usersRepository.deleteById(request.getId()));
		
		try {
			
			Userrs user = usersRepository.findById(request.getId());
					
			usersRepository.delete(user);
			
			response.setStatus(Status.SUCESSO);
			
		} catch (Exception e) {
			
			response.setStatus(Status.ERRO);
		}
		
		
		/*if (response.getStatus()==Status.ERRO)
		{
			throw new Exception("Inválido ao deletar usuário com Id: "+request.getId());
		}*/
		
		return response;
		
	}
	
	
	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "SaveOrUpdateUsersRequest")
	@ResponsePayload
	public SaveOrUpdateUsersResponse saveOrUpdateUsersRequest(@RequestPayload SaveOrUpdateUsersRequest request) throws Exception  
	{
		SaveOrUpdateUsersResponse response = new SaveOrUpdateUsersResponse();
		
		Users user= request.getUser();
		
		
		if(user.getId() <= 0 )
		{
			response.setStatus(Status.ERRO);
			
			return response;
		}
		
		try {
			
			Userrs userr = new Userrs(user.getId(), user.getName(),user.getEmail(),user.getPhone());
			usersRepository.save(userr);
			response.setStatus(Status.SUCESSO);
			
		} catch (Exception e) {
			
			response.setStatus(Status.ERRO);
		}
		
		
		return response;
		
	}


}
