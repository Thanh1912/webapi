package com.example.searchjpa.controller;

import com.example.searchjpa.DTO.*;
import com.example.searchjpa.Exception.ApiError;
import com.example.searchjpa.Exception.BadRequestException;
import com.example.searchjpa.Exception.model.Errors;
import com.example.searchjpa.Exception.model.Error;
import com.example.searchjpa.Exception.model.Meta;
import com.example.searchjpa.model.Users;
import com.example.searchjpa.repository.UsersRepository;
import com.example.searchjpa.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.*;

@RestController
public class usersController {
    @Autowired
    UsersRepository usersRepository;

    @Autowired
    UsersService usersService;

//    @GetMapping("/users/search")
//    public Page<Users> home(@RequestParam("firstname") String firstname,
//                            @RequestParam("email") String email, @RequestParam("lastname") String lastname) {
//       Pageable pageable=new PageRequest(1, 5);
//       Map<String,String> map=new HashMap<>();
//        map.put("firstname","Madrid%");
//        map.put("email","Jersey@gmail.com%");
//        return  usersService.findAll(map,pageable);
//    }

    @GetMapping("/get")
   public String get(@RequestParam("id") String id) throws BadRequestException {
        Errors errors=new Errors(new Error("resource","field","code","message",""),new Meta());
        ArrayList<Errors> errorArrayList=new ArrayList<>();
        errorArrayList.add(errors);
        ApiError apiError = new ApiError(errorArrayList,new Meta());
       throw new BadRequestException(apiError);
    }
    @PostMapping("/posttest")
    @ResponseBody
    public ExceptionApi postetst(@RequestBody ExceptionApi ExceptionApi){
       return ExceptionApi;
    }




    @GetMapping("/users")
    @ResponseBody
    public Page<Users> home(@RequestParam("ids") String ids) {
        String[] ListIds = ids.split(",");
        Pageable pageable=new PageRequest(0, 5);
        List<String> list=new ArrayList<>();
        for (int i=0;i<ListIds.length;i++){
            list.add(ListIds[i].toString());
        }
        return  usersService.findAllEqIds(list,pageable);
    }

    @PostMapping("/post")
    @ResponseBody
    public Object ex(@RequestBody RootObject item) {
//        for (int i = 0; i <item.getItems().size() ; i++) {
//            Data data=item.getItems().get(i).getData();
//            if(data!=null&&data.getQuery()!=null&&data.getQuery().getFilter()!=null){
//                  Filter filter=data.getQuery().getFilter();
//                ArrayList<And> listFilterAnd=filter.getAnd();
//                for (int j = 0; j <listFilterAnd.size() ; j++) {
//                    if(listFilterAnd.get(j).getFilter()!=null){
//                        System.out.println(filter.getAnd().get(j).getFilter().getAttribute().getName());
//                        System.out.println(filter.getAnd().get(j).getFilter().getParameter().getEq());
//                    }
//                    if(listFilterAnd.get(j).getAnd()!=null){
//                        ArrayList<And> listFilterAnd_listAnd=listFilterAnd.get(j).getAnd();
//                        for (int k = 0; k < listFilterAnd_listAnd.size(); k++) {
//                            System.out.println(listFilterAnd_listAnd.get(k).getFilter().getAttribute().getName());
//                        }
//                    }
//                }
//            }
//        }
        Pageable pageable=new PageRequest(0, 5);
        return  usersService.findAllFilterPost(item,pageable);
    }

    public static Map<String, Object> getFieldNamesAndValues(final Object obj, boolean publicOnly)
            throws IllegalArgumentException,IllegalAccessException
    {
        Class<? extends Object> c1 = obj.getClass();
        Map<String, Object> map = new HashMap<String, Object>();
        Field[] fields = c1.getDeclaredFields();
        for (int i = 0; i < fields.length; i++) {
            String name = fields[i].getName();
            if (publicOnly) {
                if(Modifier.isPublic(fields[i].getModifiers())) {
                    Object value = fields[i].get(obj);
                    map.put(name, value);
                }
            }
            else {
                fields[i].setAccessible(true);
                Object value = fields[i].get(obj);
                System.out.println("name: "+name);
                System.out.println("value: "+value);
                map.put(name, value);
            }
        }
        return map;
    }











/*
    @GetMapping("/findall")
    public  List<Users> finall() {
        return usersRepository.findAll();
    }


    @GetMapping("/search/user/{text}")
    public List<Users> search(@PathVariable String text ) {
        long start = System.currentTimeMillis();
        List<Users> list=usersRepository.find(text);
        long end   = System.currentTimeMillis();
        NumberFormat formatter = new DecimalFormat("#0.00000");
        System.out.print("Execution time is " + formatter.format((end - start) / 1000d) + " seconds");
        return list;
   }

    @GetMapping("/getpage")
    public Page<Users> searchf( ) {
        long start = System.currentTimeMillis();
        Pageable pageable=new PageRequest(1, 5);
        Page<Users> list=usersRepository.findAll(pageable);
        long end   = System.currentTimeMillis();
        NumberFormat formatter = new DecimalFormat("#0.00000");
        System.out.print("Execution time is " + formatter.format((end - start) / 1000d) + " seconds");
        return list;
    }

*/

}
