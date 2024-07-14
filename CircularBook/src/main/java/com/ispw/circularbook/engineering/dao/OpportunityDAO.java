package com.ispw.circularbook.engineering.dao;

import com.ispw.circularbook.engineering.connection.ConnectionDB;
import com.ispw.circularbook.engineering.dao.queries.CRUDQueries;
import com.ispw.circularbook.engineering.dao.queries.Queries;
import com.ispw.circularbook.engineering.exception.ErrorConnectionDbException;
import com.ispw.circularbook.engineering.exception.NoOpportunityFoundException;
import com.ispw.circularbook.model.BookShopModel;
import com.ispw.circularbook.model.OpportunityModel;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class OpportunityDAO {

    private OpportunityDAO(){}

    public static List<OpportunityModel> searchOpportunity(String bookShopName, String month, String typeOfOpportunity) throws NoOpportunityFoundException {

            Statement stmt;
            ResultSet resultSet;
            List<OpportunityModel> opportunityModelList = new ArrayList<>();
            try {
                stmt = ConnectionDB.getConnection();
                resultSet= Queries.searchOpportunity(stmt, bookShopName,typeOfOpportunity,month);
                if(!resultSet.first())
                {
                    throw new NoOpportunityFoundException();
                }

                resultSet.next();
                // Riposiziono il cursore sul primo record del result set
                resultSet.first();
                do{
                    OpportunityModel opportunityModel = new OpportunityModel();
                    BookShopModel bookShopModel = new BookShopModel();
                    opportunityModel.setId(resultSet.getInt(1));
                    bookShopModel.setEmail(resultSet.getString(2));
                    opportunityModel.setBookShopModel(bookShopModel);
                    opportunityModel.setBookShopName(resultSet.getString(3));
                    opportunityModel.setTypeOfOpportunity(resultSet.getInt(4));
                    opportunityModel.setTitle(resultSet.getString(5));
                    opportunityModel.setDescription(resultSet.getString(6));
                    opportunityModel.setDateStart(resultSet.getString(7));
                    opportunityModel.setDateFinish(resultSet.getString(8));
                    opportunityModelList.add(opportunityModel);
                }while (resultSet.next());

                resultSet.close();
            } catch (SQLException | ErrorConnectionDbException  e) {
                e.printStackTrace();
            }

        return opportunityModelList;

    }

    public static List<OpportunityModel> searchOpportunity(String email) throws NoOpportunityFoundException {

        Statement stmt;
        ResultSet resultSet;
        List<OpportunityModel> opportunityModelList = new ArrayList<>();
        try {
            stmt = ConnectionDB.getConnection();
            resultSet= Queries.searchOpportunity(stmt,email);
            if(!resultSet.first())
            {
                throw new NoOpportunityFoundException();
            }

            resultSet.next();
            // Riposiziono il cursore sul primo record del result set
            resultSet.first();
            do{
                BookShopModel bookShopModel = new BookShopModel();
                OpportunityModel opportunityModel = new OpportunityModel();
                opportunityModel.setId(resultSet.getInt(1));
                bookShopModel.setEmail(resultSet.getString(2));
                opportunityModel.setBookShopModel(bookShopModel);
                opportunityModel.setTypeOfOpportunity(resultSet.getInt(3));
                opportunityModel.setTitle(resultSet.getString(4));
                opportunityModel.setDescription(resultSet.getString(5));
                opportunityModel.setDateStart(resultSet.getString(6));
                opportunityModel.setDateFinish(resultSet.getString(7));
                opportunityModelList.add(opportunityModel);
            }while (resultSet.next());

            resultSet.close();
        } catch (SQLException | ErrorConnectionDbException e) {
            e.printStackTrace();
        }

        return opportunityModelList;

    }

    public static void insertOpportunity(OpportunityModel opportunityModel){
        Statement stmt;
        try {
            stmt=ConnectionDB.getConnection();
            CRUDQueries.insertOpportunity(stmt, opportunityModel.getBookShopModel().getEmail(), opportunityModel.getTitle(), opportunityModel.getTypeOfOpportunity(), opportunityModel.getDescription(), opportunityModel.getDateStartString(), opportunityModel.getDateFinishString());
        } catch (ErrorConnectionDbException | SQLException e) {
            e.printStackTrace();
        }
    }

    public static void updateOpportunity(OpportunityModel opportunityModel) {
        Statement stmt;
        try {
            stmt=ConnectionDB.getConnection();
            CRUDQueries.updateOpportunity(stmt, opportunityModel.getId(), opportunityModel.getTitle(), opportunityModel.getTypeOfOpportunity(),opportunityModel.getDescription(), opportunityModel.getDateStartString(), opportunityModel.getDateFinishString());
        }catch (ErrorConnectionDbException | SQLException e) {
            e.printStackTrace();
        }
    }

    public static void removeOpportunity(int id){

        Statement stmt;
        try {
            stmt=ConnectionDB.getConnection();
            CRUDQueries.removeOpportunity(stmt, id);
        } catch (ErrorConnectionDbException | SQLException e) {
            e.printStackTrace();
        }

    }
}
