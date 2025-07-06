# Extract all unique UDP payloads sent to port 7080
tshark -r your.pcap -Y "udp.dstport == 7080" -T fields -e data | sort | uniq
