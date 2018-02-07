package com.example.searchjpa.DTO;

import java.util.ArrayList;

public class Or {

        public Filter filter;

        public Filter getFilter() { return this.filter; }

        public void setFilter(Filter filter) { this.filter = filter; }

        private ArrayList<Or> or;

        public ArrayList<Or> getOr() { return this.or; }

        public void setOr(ArrayList<Or> or) { this.or = or; }


        private ArrayList<And> and;

        public ArrayList<And> getAnd() { return this.and; }

        public void setAnd(ArrayList<And> and) { this.and = and; }

}
