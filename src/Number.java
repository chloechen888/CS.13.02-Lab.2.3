public class Number {
    private int denary;

    public Number(int denary) {
        this.denary = denary;
    }

    public int getDenary() {
        return this.denary;// tick
    }

    public void setDenary(int denary) {
        this.denary = denary;
    }//tick

    public String getSignedBinary() {
//        StringBuilder binaryBuilder = new StringBuilder();
        int denary = this.denary;
        int numBits = 8;

        if (denary == 0) {
            return padWithZeros("0", numBits);
        }

        boolean isNegative = false;
        if (denary < 0) {
            isNegative = true;
            denary = -denary;
        }

        StringBuilder binary = new StringBuilder();
        while (denary > 0) {

            int remainder = denary % 2;
            binary.insert(0, remainder);
            denary = denary / 2;
        }

        String binaryRepresentation = binary.toString();

        // Pad with them 0s
        binaryRepresentation = padWithZeros(binaryRepresentation, numBits);

        if (isNegative) {
            System.out.println("it be negative though");
            binaryRepresentation = computeTwosComplement(binaryRepresentation);
        }

        return binaryRepresentation;

        //FINA;;Y OIT WORKS


    }

    public String computeTwosComplement(String b) {
        StringBuilder complement = new StringBuilder();

        boolean foundFirstOne = false;
        for (int i = b.length() - 1; i >= 0; i--) {
            if (b.charAt(i) == '0' && !foundFirstOne) {
                complement.insert(0, "0");
            } else if (b.charAt(i) == '1' && !foundFirstOne) {
                complement.insert(0, "1");
                foundFirstOne = true;
            } else {
                if (b.charAt(i) == '0') {
                    complement.insert(0, "1");
                } else {
                    complement.insert(0, "0");
                }
            }
        }

        return complement.toString();
    }

    public String padWithZeros(String binary, int targetLength) {
        if(binary.length()<=7) {
            System.out.println("now this ait logircing");
            while (binary.length() < targetLength) {
                binary = "0" + binary;
            }
            return  binary;
        }
        if(binary.length()>=8)
        {
            System.out.println("ejrgt");
            while (binary.length() < targetLength+1) {
                binary = "0" + binary;
            }
            return binary;
        }
        return null;

    }


        public String getHexadecimal() {
            StringBuilder hexadecimal = new StringBuilder();
            String binary = getSignedBinary(); // get that binary on yk what I mean
            int dec =0; //head be hurting bro
            int pushingP =0;

            for (int i = binary.length()-1; i >=0; i--) {

                int digit = binary.charAt(i) - '0';
                dec += digit * Math.pow(2, pushingP);
                pushingP++;
                System.out.println("I wanna sleep");
            }

            while(dec>0)
            {
                System.out.println("I wanna sleep");
                int decimalValue = dec%16;
                char hexChar = (char) (decimalValue < 10 ? (decimalValue + '0') : (decimalValue - 10 + 'A'));//converting the decimal value of a digit ( 0 to 15) into its corresponding hexadecimal character. thank gosh for this burh
                hexadecimal.insert(0,hexChar);
                dec =dec/16;

            }
//dang this makes my head hurt

            return hexadecimal.toString();
        }

    public String getSignedBinary(int number) {
        if (number == 0) {
            return "0";
        }

        StringBuilder binary = new StringBuilder();

        while (number != 0) {
            binary.insert(0, number & 1);
            number = number >>> 1;
        }
//
        return binary.toString();

    }





        @Override
        public String toString() {
            return "Number{" +
                    "denary=" + denary +
                    " binary=" + getSignedBinary() +
                    " hexadecimal=" + getHexadecimal() +
                    "}";
        }
//        public String

        public void negate() {
            denary = -denary;
        }
    }


