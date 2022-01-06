//package com.example.CoinListing.DTO;
//
//import com.example.CoinListing.Model.Users;
//import org.springframework.stereotype.Component;
//
//import java.util.List;
//import java.util.stream.Collectors;
//
//@Component
//public class DTOConverter {
//
//    public ResponseDTO entityToDTO(Users users)
//    {
//        ResponseDTO dto = new ResponseDTO();
//        dto.setCode(200);
//        dto.setMessage("Values are displayed");
//        dto.setUsers(users);
//    }
//    public List<ResponseDTO> entityToDTO(List<Users> usersList)
//    {
//        return usersList.stream().map(x-> entityToDTO(x)).collect(Collectors.toList());
//    }
//}
